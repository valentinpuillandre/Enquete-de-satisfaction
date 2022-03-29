package com.example.mysncf_jv_2022;

import java.util.HashMap;

public class SNCF
{
    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();

    public static void initialiser ()
    {
        if(! lesEnquetes.containsKey("rerA"))
        {
            lesEnquetes.put("rerA", new Enquete());
        }
        if(! lesEnquetes.containsKey("rerB"))
        {
            lesEnquetes.put("rerB", new Enquete());
        }
        if(! lesEnquetes.containsKey("rerC"))
        {
            lesEnquetes.put("rerC", new Enquete());
        }
        if(! lesEnquetes.containsKey("rerD"))
        {
            lesEnquetes.put("rerD", new Enquete());
        }
        if(! lesEnquetes.containsKey("rerE"))
        {
            lesEnquetes.put("rerE", new Enquete());
        }
    }
    public static Enquete getUneEnquete (String rer)
    {
        return lesEnquetes.get(rer);
    }
}
