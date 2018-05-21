import java.util.*;

public class BaseDeDados
{

    private Map<String,Contribuintes> contribuintes;
    
    public BaseDeDados(){
        contribuintes = new HashMap<>();
}

    public BaseDeDados(Map<String,Contribuintes> l){
        contribuintes = new HashMap<>();
        
        for(String s : contribuintes.keySet()){
            contribuintes.put(s,l.get(s).clone());
    }
}

    public BaseDeDados(BaseDeDados b){
    contribuintes = b.getContribuinte();
}

    public Map<String,Contribuintes> getContribuinte(){
    Map<String,Contribuintes> res = new HashMap<>();
    for(String s : contribuintes.keySet()){
        res.put(s,contribuintes.get(s).clone());
    }
    return res;
}
}