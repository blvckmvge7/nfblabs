package com.nfblabs.nfblabs;

import com.nfblabs.nfblabs.model.*;
import com.nfblabs.nfblabs.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired private CursoRepository cursoRepository;
    @Autowired private EstudianteRepository estudianteRepository;
    @Autowired private InstructorRepository instructorRepository;
    @Autowired private ModuloRepository moduloRepository;
    @Autowired private LeccionRepository leccionRepository;
    @Autowired private InscripcionRepository inscripcionRepository;
    @Autowired private NotificacionRepository notificacionRepository;
    @Autowired private PagoRepository pagoRepository;
    @Autowired private CategoriaRepository categoriaRepository;
    @Autowired private CertificadoRepository certificadoRepository;
    @Autowired private CalificacionRepository calificacionRepository;
    @Autowired private ComentarioRepository comentarioRepository;
    @Autowired private PreguntaRepository preguntaRepository;
    @Autowired private RespuestaRepository respuestaRepository;
    @Autowired private EvaluacionRepository evaluacionRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        // Categorias
        for (int i = 0; i < 5; i++) {
            Categoria categoria = new Categoria();
            categoria.setNombre(faker.educator().campus());
            categoria.setDescripcion(faker.lorem().sentence());
            categoriaRepository.save(categoria);
        }
        List<Categoria> categorias = categoriaRepository.findAll();

        // Cursos
        for (int i = 0; i < 10; i++) {
            Curso curso = new Curso();
            curso.setNombre(faker.educator().course());
            curso.setDescripcion(faker.lorem().sentence());
            // Si tu modelo tiene relación con categoria, asígnala aquí
            cursoRepository.save(curso);
        }
        List<Curso> cursos = cursoRepository.findAll();

        // Instructores
        for (int i = 0; i < 5; i++) {
            Instructor instructor = new Instructor();
            instructor.setNombre(faker.name().firstName());
            instructor.setApellido(faker.name().lastName());
            instructor.setEmail(faker.internet().emailAddress());
            instructorRepository.save(instructor);
        }
        List<Instructor> instructores = instructorRepository.findAll();

        // Estudiantes
        for (int i = 0; i < 20; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(faker.name().firstName());
            estudiante.setApellido(faker.name().lastName());
            estudiante.setEmail(faker.internet().emailAddress());
            estudianteRepository.save(estudiante);
        }
        List<Estudiante> estudiantes = estudianteRepository.findAll();

        // Modulos
        for (Curso curso : cursos) {
            for (int i = 0; i < 2; i++) {
                Modulo modulo = new Modulo();
                modulo.setNombre(faker.educator().course());
                modulo.setDescripcion(faker.lorem().sentence());
                modulo.setCurso(curso);
                moduloRepository.save(modulo);
            }
        }
        List<Modulo> modulos = moduloRepository.findAll();

        // Lecciones
        for (Modulo modulo : modulos) {
            for (int i = 0; i < 3; i++) {
                Leccion leccion = new Leccion();
                leccion.setTitulo(faker.book().title());
                leccion.setUrlVideo(faker.internet().url());
                leccion.setModulo(modulo);
                leccionRepository.save(leccion);
            }
        }

        // Inscripciones
        for (Estudiante estudiante : estudiantes) {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setEstudiante(estudiante);
            inscripcion.setCurso(cursos.get(random.nextInt(cursos.size())));
            inscripcion.setFechaInscripcion(LocalDate.now().minusDays(random.nextInt(30)));
            inscripcionRepository.save(inscripcion);
        }

        // Notificaciones
        for (Estudiante estudiante : estudiantes) {
            Notificacion notificacion = new Notificacion();
            notificacion.setEstudiante(estudiante);
            notificacion.setMensaje(faker.lorem().sentence());
            notificacion.setLeida(random.nextBoolean());
            notificacion.setFecha(LocalDateTime.now());
            notificacionRepository.save(notificacion);
        }

        // Pagos
        for (Estudiante estudiante : estudiantes) {
            Pago pago = new Pago();
            pago.setEstudiante(estudiante);
            pago.setCurso(cursos.get(random.nextInt(cursos.size())));
            pago.setMonto(faker.number().randomDouble(2, 100, 1000));
            pago.setFecha(LocalDateTime.now().minusDays(random.nextInt(30)));
            pagoRepository.save(pago);
        }

        // Certificados
        for (Estudiante estudiante : estudiantes) {
            Certificado certificado = new Certificado();
            certificado.setEstudiante(estudiante);
            certificado.setCurso(cursos.get(random.nextInt(cursos.size())));
            certificado.setFecha(LocalDate.now().minusDays(random.nextInt(365)));
            certificadoRepository.save(certificado);
        }

        // Calificaciones
        for (Estudiante estudiante : estudiantes) {
            Calificacion calificacion = new Calificacion();
            calificacion.setEstudiante(estudiante);
            calificacion.setCurso(cursos.get(random.nextInt(cursos.size())));
            calificacion.setNota(faker.number().randomDouble(1, 1, 10));
            calificacionRepository.save(calificacion);
        }

        // Comentarios
        for (Estudiante estudiante : estudiantes) {
            Comentario comentario = new Comentario();
            comentario.setEstudiante(estudiante);
            comentario.setCurso(cursos.get(random.nextInt(cursos.size())));
            comentario.setTexto(faker.lorem().sentence());
            comentario.setFecha(LocalDateTime.now().minusDays(random.nextInt(30)));
            comentarioRepository.save(comentario);
        }

        // Evaluaciones
        for (Curso curso : cursos) {
            Evaluacion evaluacion = new Evaluacion();
            evaluacion.setCurso(curso);
            evaluacion.setFecha(LocalDate.now().minusDays(random.nextInt(30)));
            evaluacion.setDescripcion(faker.lorem().sentence());
            evaluacionRepository.save(evaluacion);
        }
        List<Evaluacion> evaluaciones = evaluacionRepository.findAll();

        // Preguntas y Respuestas
        for (Evaluacion evaluacion : evaluaciones) {
            for (int i = 0; i < 5; i++) {
                Pregunta pregunta = new Pregunta();
                pregunta.setEvaluacion(evaluacion);
                pregunta.setTexto(faker.lorem().sentence());
                preguntaRepository.save(pregunta);

                for (int j = 0; j < 4; j++) {
                    Respuesta respuesta = new Respuesta();
                    respuesta.setPregunta(pregunta);
                    respuesta.setTexto(faker.lorem().word());
                    respuesta.setCorrecta(j == 0); // Solo la primera es correcta
                    respuestaRepository.save(respuesta);
                }
            }
        }
    }
}