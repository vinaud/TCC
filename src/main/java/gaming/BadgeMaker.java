package gaming;

import entities.Badge;
import entities.User;
import persistence.BadgeDAOHibernate;

public class BadgeMaker {

    public static void earnFirstBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Primeira Tarefa");
        badge.setObjetivo("Validar a primeira tarefa no sistema");
        badge.setIcon("b1");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }

    public static void earnInicianteIBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Testador iniciante I");
        badge.setObjetivo("Validar 10 tarefas");
        badge.setIcon("b2");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }

    public static void earnInicianteIIBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Testador iniciante II");
        badge.setObjetivo("Validar 20 tarefas");
        badge.setIcon("b3");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }

    public static void earnIntermediarioIBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Testador intermediario I");
        badge.setObjetivo("Validar 30 tarefas");
        badge.setIcon("b4");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }

    public static void earnIntermediarioIIBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Testador intermediario II");
        badge.setObjetivo("Validar 40 tarefas");
        badge.setIcon("b5");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }

    public static void earnIntermediarioIIIBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Testador intermediario III");
        badge.setObjetivo("Validar 50 tarefas");
        badge.setIcon("b6");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }

    public static void earnAvancadoIBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Testador avançado I");
        badge.setObjetivo("Validar 80 tarefas");
        badge.setIcon("b7");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }

    public static void earnAvancadoIIBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Testador avançado II");
        badge.setObjetivo("Validar 100 tarefas");
        badge.setIcon("b8");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }

    public static void earnVaderBadge(User user)
    {
        Badge badge = new Badge();
        badge.setTitulo("Testador supremo");
        badge.setObjetivo("Validar 1000 tarefas");
        badge.setIcon("vader");
        badge.setUser(user);

        BadgeDAOHibernate.inserirBadge(badge);
    }



}
