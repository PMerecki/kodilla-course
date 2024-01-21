package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("1/2024");

        Product bread = new Product("Bread");
        Product water = new Product("Water");
        Product ball = new Product("Ball");

        Item itemBread = new Item(bread, new BigDecimal(57), 2);
        Item itemWater = new Item(water, new BigDecimal(18), 6);
        Item itemBall = new Item(ball, new BigDecimal(3), 1);

        itemBread.setInvoice(invoice);
        itemWater.setInvoice(invoice);
        itemBall.setInvoice(invoice);

        List<Item> items = new ArrayList<>();
        items.add(itemBread);
        items.add(itemWater);
        items.add(itemBall);

        invoice.setItems(items);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int itemSize = invoice.getItems().size();

        Invoice invoiceReadFromDB = invoiceDao.findById(invoiceId);

        //Then
        assertEquals(invoiceId, invoiceReadFromDB.getId());
        assertEquals(3, itemSize);
        assertEquals(itemSize, invoiceReadFromDB.getItems().size());
    }
}