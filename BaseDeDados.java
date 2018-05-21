import java.util.*;

public class BaseDeDados
{

    private Map<Integer,Contribuintes> contribuintes;
    
    public BaseDeDados(){
        contribuintes = new HashMap<>();
}

    public BaseDeDados(Map<Integer,Contribuintes> l){
        contribuintes = new HashMap<>();
        
        for(int s : contribuintes.keySet()){
            contribuintes.put(s,l.get(s).clone());
    }
}

    public BaseDeDados(BaseDeDados b){
    contribuintes = b.getContribuinte();
}

    public Map<Integer,Contribuintes> getContribuinte(){
    Map<Integer,Contribuintes> res = new HashMap<>();
    for(int s : contribuintes.keySet()){
        res.put(s,contribuintes.get(s).clone());
    }
    return res;
}

public void addContribuinte(Contribuintes c){
        contribuintes.put(c.getNIF(),c.clone());
}

}