package com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

    @InjectMocks
    ManagerService managerService;

    @Mock
    ManagerRepository managerRepository;
    @Mock
    TechnicienRepository technicienRepository;

    @Before
    public void setUp() throws EmployeException {

    }

    @Test
    public void testAddTechniciens() {

    }
}
