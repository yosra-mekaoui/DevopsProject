package tn.esprit.devops_project.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.repositories.InvoiceRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)

public class InvoiceServiceImplTest {

    @Mock
    private  InvoiceRepository invoiceRepository ;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Test
    public void testRetrieveAllInvoices() {
        // Create a list of invoices
        Invoice invoice1 = new Invoice(50.0f, 1000.0f, new Date(), new Date(), false);

        Invoice invoice2 = new Invoice(60.0f, 1000.0f, new Date(), new Date(), false);



        List<Invoice> invoiceList = Arrays.asList(invoice1, invoice2);

        // Define the behavior of the mock repository
        when(invoiceRepository.findAll()).thenReturn(invoiceList);

        // Call the service method
        List<Invoice> result = invoiceService.retrieveAllInvoices();

        // Verify the service method and its outcome
        verify(invoiceRepository, times(1)).findAll();
        // Verify the result
        assertEquals(2, result.size());
    }


    @Test
    public void testAddInvoice() {
        // Create a reglement
        Invoice invoice1 = new Invoice(90.0f, 150.0f, new Date(), new Date(), true);

        when(invoiceRepository.save(invoice1)).thenReturn(invoice1);

        // Call the method to test
        Invoice addedInvoice = invoiceService.addInvoice(invoice1);

        // Verify if the method was called
        verify(invoiceRepository, times(1)).save(invoice1);
        // Verify the result
        assertEquals(invoice1, addedInvoice);
    }


    @Test
    public void testRetrieveInvoiceById() {
        // Arrange
        long invoiceId = 1L;
        Invoice mockInvoice = new Invoice(); // Assuming Invoice is your entity class
        when(invoiceRepository.findById(invoiceId)).thenReturn(java.util.Optional.of(mockInvoice));

        // Act
        Invoice retrievedInvoice = invoiceService.retrieveInvoice(invoiceId);

        // Assert
        assertNotNull(retrievedInvoice);
        assertEquals(mockInvoice, retrievedInvoice);

        // Verify that the repository's findById method was called with the correct ID
        verify(invoiceRepository, times(1)).findById(invoiceId);
    }





}