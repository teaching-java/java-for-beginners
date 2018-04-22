package com.hz.demo;

import java.util.HashMap;
import java.util.Map;

public class ServerExample {

    private static Map<String, Object> iocContainer = new HashMap<>();

    public static void main(String[] args) {

        System.out.println();
        startApplication();

        RequestHandler handler = (RequestHandler) iocContainer.get("handler");

        handler.handleRequest(new Request("Вася Пупкин", "Student"));
        handler.handleRequest(new Request("таблица умножения", "Exercise"));
        handler.handleRequest(new Request("Марфа Васильна", "Teacher"));

        stopApplication();
    }

    private static void startApplication() {
        Server server = new Server();

        //все созданные объекты должны быть в iocContainer
        StudentRepository repo = new StudentRepository();

        Listener studentController = new StudentController(repo);
        Listener exerciseController = new ExerciseController();
        Listener teacherController = new TeacherController();

        server.addListeners("Student", studentController);
        server.addListeners("Exercise", exerciseController);
        server.addListeners("Teacher", teacherController);

        iocContainer.put("server", server);

        RequestHandler requestHandler = new RequestHandler(server);

        iocContainer.put("handler", requestHandler);

        server.start();
    }

    private static void stopApplication() {
        Server server = (Server) iocContainer.get("server");
        server.stop();
    }

    static class RequestHandler {

        private final Server server;

        public RequestHandler(Server server) {
            this.server = server;
        }

        void handleRequest(Request request) {
            server.handleRequest(request);
        }
    }

    static class Server {

        private boolean started = false;
        private Map<String, Listener> listenersMap = new HashMap<>();

        void start() {
            started = true;
            System.out.println("start");
        }

        void stop() {
            started = false;
            System.out.println("stop");
        }

        //добавить еще один уровень абстракции - вынести логику выбора лисенера в отдальный класс
        //сделать этот класс полем класса сервер
        void handleRequest(Request request) {
            if (started) {
                System.out.println("Новый запрос");
                Listener listener = listenersMap.get(request.getKey());
                if (listener == null) {
                    throw new IllegalStateException("Can't find handler for key " + request.getKey());
                }
                listener.handleRequest(request.getData());
                System.out.println("Запрос обработан");
                System.out.println();
            } else {
                throw new IllegalStateException("server not started yet");
            }
        }

        void addListeners(String key, Listener listener) {
            listenersMap.put(key, listener);
        }
    }

    static class Request {
        private final String data;
        private final String key;

        Request(String data, String key) {
            this.data = data;
            this.key = key;
        }

        public String getData() {
            return data;
        }

        public String getKey() {
            return key;
        }
    }

    interface Listener {
        void handleRequest(String data);
    }

    //добавить еще 2 контроллера, зарегистрировать их и написать запросы для них
    //добавить в каждый контроллер по репозиторию, все объекты должны быть добавлены в iocContainer
    static class StudentController implements Listener {

        final StudentRepository studentRepository;

        public StudentController(StudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }

        @Override
        public void handleRequest(String data) {
            System.out.println("студент Двоешник " + data);
            System.out.println("оплата За Обучение " + data);
            System.out.println("домашнее Задание " + data);
            System.out.println("это контроллер студентов " + data);
        }
    }

    static class TeacherController implements Listener {
        @Override
        public void handleRequest(String data) {
            System.out.println("Я учитель " + data);
            System.out.println("поругать учеников " + data);
        }
    }

    static class ExerciseController implements Listener {
        @Override
        public void handleRequest(String data) {
            System.out.println("Номер упражнения " + data);
            System.out.println("проверить ответ " + data);
            System.out.println("проверить ход решения " + data);
            System.out.println("поставить оценку " + data);
        }
    }

    static class StudentRepository {

    }
}
