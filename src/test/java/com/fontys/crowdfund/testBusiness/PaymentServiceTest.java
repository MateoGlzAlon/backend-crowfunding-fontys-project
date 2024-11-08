package com.fontys.crowdfund.testBusiness;

import com.fontys.crowdfund.business.impl.PaymentServiceImpl;
import com.fontys.crowdfund.persistence.PaymentRepository;
import com.fontys.crowdfund.persistence.ProjectImagesRepository;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.InputDTOPayment;
import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;
import com.fontys.crowdfund.persistence.entity.PaymentEntity;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectImagesRepository projectImagesRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private static UserEntity u1;
    private static ProjectEntity p1;

    @BeforeAll
    static void setUp1() {
        u1 = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .build();

        p1 = ProjectEntity.builder()
                .id(1)
                .description("project description")
                .dateCreated(new Date())
                .moneyRaised(150f)
                .fundingGoal(1000f)
                .type("project type")
                .location("project location")
                .user(u1)
                .build();
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should get all payments")
    void get_all_payments() {
        // Arrange
        PaymentEntity payment1 = new PaymentEntity();
        payment1.setId(1); // Set an ID
        payment1.setProject(p1);
        payment1.setUser(u1);
        PaymentEntity payment2 = new PaymentEntity();
        payment2.setId(2); // Set an ID
        payment2.setProject(p1);
        payment2.setUser(u1);

        when(paymentRepository.findAll()).thenReturn(List.of(payment1, payment2));

        // Act
        List<OutputDTOPayment> payments = paymentService.getAllPayments();

        // Assert
        assertEquals(2, payments.size());
        verify(paymentRepository, times(1)).findAll();
    }

    //TO-DO
    @Disabled
    @Test
    @DisplayName("Should add payment and return output DTO")
    void add_payment() {
        // Arrange
        InputDTOPayment inputPayment = new InputDTOPayment();
        inputPayment.setBackerEmail("test@example.com");
        inputPayment.setPaymentDate(new Date());
        inputPayment.setProjectId(1);
        PaymentEntity savedPayment = new PaymentEntity();
        savedPayment.setId(1);
        UserEntity userEntity = UserEntity.builder().id(1).email("test@example.com").name("Test User").build();

        when(userRepository.findByEmail(inputPayment.getBackerEmail())).thenReturn(userEntity);
        when(projectRepository.findById(inputPayment.getProjectId())).thenReturn(Optional.of(p1));
        when(paymentRepository.save(any(PaymentEntity.class))).thenAnswer(invocation -> {
            PaymentEntity payment = invocation.getArgument(0);
            payment.setId(1); // Mock ID generation
            payment.setUser(userEntity);
            return payment;
        });

        // Act
        OutputDTOPayment result = paymentService.createPayment(inputPayment);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getPaymentId());
        verify(userRepository, times(1)).findByEmail(inputPayment.getBackerEmail());
        verify(projectRepository, times(1)).findById(inputPayment.getProjectId());
        verify(paymentRepository, times(1)).save(any(PaymentEntity.class));
    }

    @Test
    @DisplayName("Should return empty list if no payments found")
    void get_payments_no_payments() {
        // Arrange
        when(paymentRepository.findAll()).thenReturn(List.of());

        // Act
        List<OutputDTOPayment> payments = paymentService.getAllPayments();

        // Assert
        assertTrue(payments.isEmpty());
        verify(paymentRepository, times(1)).findAll();
    }

    //TO-DO
    @Disabled
    @Test
    @DisplayName("Should throw exception if user not found for payment")
    void add_payment_user_not_found() {
        // Arrange
        InputDTOPayment inputPayment = new InputDTOPayment();
        inputPayment.setBackerEmail("nonexistent@example.com");
        when(userRepository.findByEmail(inputPayment.getBackerEmail())).thenReturn(null);

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> paymentService.createPayment(inputPayment));
        assertEquals("User not found", thrown.getMessage());
        verify(userRepository, times(1)).findByEmail(inputPayment.getBackerEmail());
        verify(projectRepository, never()).findById(anyInt());
        verify(paymentRepository, never()).save(any(PaymentEntity.class));
    }
}
