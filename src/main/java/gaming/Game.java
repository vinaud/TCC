package gaming;

import entities.Erro;
import entities.Tarefa;
import entities.User;
import persistence.TarefaDAOHibernate;
import persistence.UserDAOHibernate;

public class Game {

    UserDAOHibernate dao = new UserDAOHibernate();

    public static void levelup(User user)
    {
        int oldLevel = user.getLevel();
        int newLevel = oldLevel + 1;
        user.setLevel(newLevel);

        UserDAOHibernate.update(user);

        rankUP(user);
    }

    public static void gainPoints(Tarefa t, User u)
    {
        long pontos = t.getDificuldade()*100;
        long newPontos = u.getPontos() + pontos;
        u.setPontos(newPontos);
        UserDAOHibernate.update(u);
    }

    public static void gainXP(Tarefa tarefa, User user)
    {
        long uXP = user.getExp();
        long newXP = uXP + tarefa.getXp();
        long nextxp = user.getLevel()*110;

        if (newXP >= nextxp)
        {
            uXP = newXP - nextxp;
            user.setExp(uXP);
            levelup(user);
        }

        else
        {
            user.setExp(newXP);
        }

        UserDAOHibernate.update(user);
    }

    public static void rankUP(User user)
    {

        if(user.getLevel() == 30)
        {
            user.setPatente("intermedirio");
            UserDAOHibernate.update(user);
        }

        else if (user.getLevel() == 60)
        {
            user.setPatente("avancado");
            UserDAOHibernate.update(user);
        }
    }

    public static void earnBadge(Tarefa tarefa, User user)
    {

        switch(user.getCounter())
        {
            case 1:
                BadgeMaker.earnFirstBadge(user);
                break;
            case 10:
                BadgeMaker.earnInicianteIBadge(user);
                break;
            case 20:
                BadgeMaker.earnInicianteIIBadge(user);
                break;
            case 30:
                BadgeMaker.earnIntermediarioIBadge(user);
                break;
            case 40:
                BadgeMaker.earnIntermediarioIIBadge(user);
                break;
            case 50:
                BadgeMaker.earnIntermediarioIIBadge(user);
                break;
            case 80:
                BadgeMaker.earnAvancadoIBadge(user);
                break;
            case 100:
                BadgeMaker.earnAvancadoIIBadge(user);
                break;
            case 1000:
                BadgeMaker.earnVaderBadge(user);
                break;

        }
    }


    public static void updateTarefaXP(Tarefa t, Erro e)
    {
        long newxp = 0;
        if(e.getTipo().equals("visual"))
        {
            newxp = 20;
        }
        else if( e.getTipo().equals("bd"))
        {
            newxp = 50;
        }
        else if( e.getTipo().equals("ci"))
        {
            newxp = 100;
        }

        else if( e.getTipo().equals("negocio"))
        {
            newxp = 80;
        }

        t.setXp(t.getXp()+newxp);

        TarefaDAOHibernate.update(t);
    }

}
