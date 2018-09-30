package gaming;

import entities.Erro;
import entities.Tarefa;
import entities.User;
import persistence.TarefaDAOHibernate;
import persistence.UserDAOHibernate;

public class Game {

    UserDAOHibernate dao = new UserDAOHibernate();

    public static void levelup()
    {

    }

    public static void gainPoints()
    {

    }

    public static void gainXP(User user, Tarefa tarefa)
    {

    }

    public static void rankUP()
    {

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
            newxp = 50;
        }
        else if( e.getTipo().equals("ajuste"))
        {
            newxp = 80;
        }

        else if( e.getTipo().equals("negocio"))
        {
            newxp = 100;
        }

        t.setXp(t.getXp()+newxp);

        TarefaDAOHibernate.update(t);
    }

}
