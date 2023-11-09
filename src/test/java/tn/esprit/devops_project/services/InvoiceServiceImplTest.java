package tn.esprit.devops_project.services;



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.services.Iservices.IInvoiceService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class InvoiceServiceImplTest {

    @Autowired
    IInvoiceService invoiceService;



    @Test
    public void testAddInvoice() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("30/09/2000");
        Date date2 = dateFormat.parse("25/10/2000");
        Invoice I = new Invoice(1f,2f,date1,date2,false);
        Invoice savedInvoice= invoiceService.addInvoice(I);
        assertNotNull(savedInvoice.getIdInvoice());
    }

    @Test
    public void testRetrieveInvoiceByid() {
        Invoice invoice = invoiceService.retrieveInvoice(1L);
        assertNotNull(invoice.getIdInvoice());
    }



    @Test
    public void testRetrieveAllInvoives() throws ParseException {
        List<Invoice> factures = invoiceService.retrieveAllInvoices();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("30/09/2000");
        Date date2 = dateFormat.parse("25/10/2000");
        int expected = factures.size();
        Invoice f = new Invoice();

        f.setDateCreationInvoice(date1);
        f.setDateLastModificationInvoice(date2);
        f.setArchived(true);
        f.setAmountInvoice(1.5f);
        Invoice savedFacture= invoiceService.addInvoice(f);
        assertEquals(expected + 1, invoiceService.retrieveAllInvoices().size());
    }



//    @Test
//    public void testCancelInvoice() throws ParseException  {
//        Invoice sa = new Invoice();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date date1 = dateFormat.parse("30/09/2020");
//        Date date2 = dateFormat.parse("05/12/2022");
//        sa.setDateCreationInvoice(date1);
//        sa.setDateLastModificationInvoice(date2);
//        sa.setArchived(true);
//        sa.setAmountInvoice(1.5f);
//        Invoice savedfacture= invoiceService.addInvoice(sa);
//        invoiceService.cancelInvoice(savedfacture.getIdInvoice());
//        assertNotNull(sa.getIdInvoice());
//    }




}