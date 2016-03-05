package dk.cngroup.hakka.web;

import dk.cngroup.hakka.controller.errors.CustomErrorController;
import dk.cngroup.hakka.controller.routes.ErrorRoutes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringApplicationConfiguration(classes = {MockServletContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CustomErrorControllerTest {

    private MockMvc mockMvc;

    private CustomErrorController controller;

    @Before
    public void setUp() {
        controller = new CustomErrorController();
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void getNotFoundError() throws Exception {
        mockMvc.perform(get(ErrorRoutes.NOT_FOUND))
                .andExpect(status().isOk()) //status is ok because controller found the endpoint
                .andExpect(jsonPath("$.message").value("This is probably not what you are looking for"));
    }
}
