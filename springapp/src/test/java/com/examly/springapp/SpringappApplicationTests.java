package com.examly.springapp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import com.examly.springapp.model.Product;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class) // Specify the test runner
@WebMvcTest
public class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    private final List<Object> cart = new ArrayList<>();

    @Before // Use @Before instead of @BeforeEach for JUnit 4
    public void setup() {
        MockitoAnnotations.initMocks(this); // Initialize mocks
        cart.clear();
    }

    @Test
    public void testAddToCart() throws Exception {
        String productJson = "{\"name\":\"Test Product\",\"price\":10.0,\"quantity\":2}";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        // You can use any verification logic or assertions here, as you are not directly mocking the controller.
    }

    @Test
    public void testGetTotalPrice() throws Exception {
        cart.add(new Object()); // Adding a placeholder object

        mockMvc.perform(MockMvcRequestBuilders
                .get("/cart/total"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        // You can use any verification logic or assertions here, as you are not directly mocking the controller.
    }

 
}
