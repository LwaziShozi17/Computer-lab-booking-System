package za.ac.cput.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.Domain.Faculty;
import za.ac.cput.Repository.FacultyRepository;
import za.ac.cput.Service.impl.FacultyServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FacultyServiceTest {

    @Mock
    private FacultyRepository facultyRepository;

    @InjectMocks
    private FacultyServiceImpl facultyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        Faculty faculty = new Faculty.Builder()
                .setFacultyId("F001")
                .setFacultyName("Computer Science")
                .build();

        when(facultyRepository.save(faculty)).thenReturn(faculty);

        Faculty created = facultyService.create(faculty);
        assertNotNull(created);
        assertEquals("F001", created.getFacultyId());
    }

    @Test
    void read() {
        Faculty faculty = new Faculty.Builder()
                .setFacultyId("F001")
                .setFacultyName("Computer Science")
                .build();

        when(facultyRepository.findById("F001")).thenReturn(Optional.of(faculty));

        Faculty found = facultyService.read("F001");
        assertNotNull(found);
        assertEquals("Computer Science", found.getFacultyName());
    }

    @Test
    void getAll() {
        Faculty faculty1 = new Faculty.Builder()
                .setFacultyId("F001")
                .setFacultyName("Computer Science")
                .build();

        Faculty faculty2 = new Faculty.Builder()
                .setFacultyId("F002")
                .setFacultyName("Engineering")
                .build();

        when(facultyRepository.findAll()).thenReturn(Arrays.asList(faculty1, faculty2));

        List<Faculty> faculties = facultyService.getAll();
        assertEquals(2, faculties.size());
    }
}
