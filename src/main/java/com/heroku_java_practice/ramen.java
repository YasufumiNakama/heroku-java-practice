package com.heroku_java_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.*;
import com.hp.hpl.jena.query.*;

public class ramen {
	
	public static String path = new File(".").getAbsoluteFile().getParent();
	public static String Resources = path + "/src/main/resources/";

    public static HashSet<String> get_ramen() throws FileNotFoundException {
        // owlファイルの読み込み
        Model model = FileManager.get().loadModel(Resources + "owl/ramen.owl");
        // query
        String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
        		             "SELECT ?y\n" +
                			 "WHERE{\n" +
                             "?y rdfs:subClassOf <http://www.semanticweb.org/nakamayasufumi/ontologies/2019/5/untitled-ontology-30#ラーメン>\n" +
                             "}";
        // result
        HashSet<String> result = new HashSet<>();
        // SPARQLクエリの読み込み
        Query query = QueryFactory.create(queryString);
        // SPARQLクエリの実行
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        try {
            ResultSet results = qexec.execSelect();
            for (; results.hasNext(); ) {
                QuerySolution soln = results.nextSolution();
                Resource y = soln.getResource("y");
                result.add(y.toString().split("#")[y.toString().split("#").length-1]);
            }
        } finally {
            qexec.close();
        }
        return result;
    }
}
