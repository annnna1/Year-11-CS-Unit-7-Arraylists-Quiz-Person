import java.lang.reflect.Array;
import java.util.ArrayList;

public class PersonFactory {

    private ArrayList<Person> allPersons;

    public PersonFactory()
    {
        allPersons = new ArrayList<>();
    }

    public void addPerson(Person person)
    {
        allPersons.add(person);
        for(int i = allPersons.size()-2 ; i >=0 ; i --)
        {
            Person person2 = allPersons.get(i);
            if(person.getLastName().compareTo(person2.getLastName())==-1)
            {
                allPersons.set(i, person);
                allPersons.add(i + 1, person2);
            }
        }
    }

    public ArrayList<Person> under18()
    {
        ArrayList<Person> under18 = new ArrayList<>();
        for(int i = 0 ; i < allPersons.size() ; i++)
        {
            if(allPersons.get(i).getAge()<18)
            under18.add(allPersons.get(i));
        }
        return under18;
    }

    public boolean checkLastName(String lastName)
    {
        boolean bool = false;
        for(int i = 0 ; i < allPersons.size() ; i++)
        {
            if(lastName.equals(allPersons.get(i).getLastName()))
            {
                bool = true;
            }

        }
        return bool;
    }
}
