package qwerty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;


class Variable
{
    public String name;
    public String datatype;
}

@WebServlet("/SymbolTable")
public class SymbolTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SymbolTable() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String fileName= request.getParameter("file");
		System.out.println(fileName);
		
		out.print("<!DOCTYPE html><html><head><title>Semantic Analysis</title>"
				+ "<link href=\"css/style3.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />"
				+ "<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\"><link rel=\"css/bootstrap.min.css\"><link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' /><link rel=\"stylesheet\" type=\"text/css\" href=\"css/animate.css\"/>"
				+ "<script src=\"js/jquery.min.js\"></script>"
				+ " <script src=\"js/bootstrap.min.js\"></script>"
				+ "<script type=\"text/javascript\" src=\"js/wow.js\"></script>"
				+ "<script src=\"js/wow.min.js\"></script>"
				+ "<script>new WOW().init();</script>"
				+ "<script> $(document).ready(function(){    $(\"#flip\").click(function(){"
				+ "$(\"#panel\").slideToggle(\"slow\");    });});$(document).ready(function(){"
				+ "    $(\"#flip2\").click(function(){        $(\"#panel2\").slideToggle(\"slow\");    });});</script>"
		
				+ "</head><body>");
		
		out.print("<header><div class=\"container\"><div class=\"logo pull-left animated wow fadeInLeft\">Semantic Analyzer</div></div></header>");
		
		out.println("<body><html>");
	
	        try
	        {

	        	String s;
	        	ArrayList<Variable> var_list = new ArrayList<Variable>();  
	            ArrayList<String> var_list_temp = new ArrayList<String>();  

	        	String keywords[] = {"main","static","public","void","int","float","String"};
	        	String complex_words[] = {"return ","if","else","case ","default","for","while","break","continue","&&","||",":","catch","try","finally","throw"};
	 
	        	int complexity = 0,line = 0;
	        	
	        	String file="D:\\Documents\\Programs\\workspace\\qwerty\\src\\qwerty\\";
	        	String output="";
	        	file=file.concat(fileName);
	            File f = new File(file);
	            FileReader fl = new FileReader(f);
	            BufferedReader bf = new BufferedReader(fl);
	            
	            out.println("<div id=\"flip2\" >Errors</div><div id=\"panel2\">");


	            while((s=bf.readLine()) != null)
		            {
		                line++;
	
		                StringTokenizer str = new StringTokenizer(s);
		                String a[],b[],c[];
	
		                //System.out.println(str);
	                    
	                if(s.contains("int ") == true)
	                {
	                    //System.out.println(s);
	                    s=s.replaceAll(","," ");
	                    s=s.replaceAll("[^a-zA-Z0-9_]+"," ");
	                    //s=s.replaceAll(")"," ");
	                    a=s.split(" ");

	                    for(int i = 0;i<a.length;i++)
	                    {
	                    	if((a[i].trim().length() > 0) && !a[i].matches("[0-9]+") && !var_list_temp.contains(a[i])) // to check its not all whitespaces
	                    	{
	                    		if(!a[i].equals("int") && !a[i].equals("new") && !a[i].contains("int[") && !a[i].equals("=") && !Arrays.asList(keywords).contains(a[i]))
	                    		{
	                    			a[i] = a[i].replaceAll(";","");
	                                Variable variable = new Variable();
	                                variable.name = a[i];
	                                variable.datatype = "int";
	                    			var_list.add(variable);
	                                var_list_temp.add(a[i]);
	                    			//System.out.println(i + " " + a[i]);
	                    		}	
	                    	}
	                    }
	                }
	                else if(s.contains("float ") == true)
	                {
	                    //System.out.println(s);
	                    s=s.replaceAll(","," ");
	                    s=s.replaceAll("[^a-zA-Z0-9_]+"," ");
	                    a=s.split(" ");

	                    for(int i = 0;i<a.length;i++)
	                    {
	                    	if((a[i].trim().length() > 0) && !a[i].matches("[0-9]+") && !var_list_temp.contains(a[i])) // to check its not all whitespaces
	                    	{
	                    		if(!a[i].equals("float") && !a[i].equals("new") && !a[i].contains("float[") && !a[i].equals("=") && !Arrays.asList(keywords).contains(a[i]))
	                    		{
	                    			a[i] = a[i].replaceAll(";","");
	                    			Variable variable = new Variable();
	                                variable.name = a[i];
	                                variable.datatype = "float";
	                                var_list.add(variable);
	                                var_list_temp.add(a[i]);
	                    			//System.out.println(i + " " + a[i]);
	                    		}	
	                    	}
	                    }
	                }
	                else if(s.contains("double ") == true)
	                {
	                    //System.out.println(s);
	                    s=s.replaceAll(","," ");
	                    s=s.replaceAll("[^a-zA-Z0-9_]+"," ");
	                    a=s.split(" ");

	                    for(int i = 0;i<a.length;i++)
	                    {
	                    	if((a[i].trim().length() > 0) && !a[i].matches("[0-9]+") && !var_list_temp.contains(a[i])) // to check its not all whitespaces
	                    	{
	                    		if(!a[i].equals("double") && !a[i].equals("new") && !a[i].contains("double[") && !a[i].equals("=") && !Arrays.asList(keywords).contains(a[i]))
	                    		{
	                    			a[i] = a[i].replaceAll(";","");
	                    			Variable variable = new Variable();
	                                variable.name = a[i];
	                                variable.datatype = "double";
	                                var_list.add(variable);
	                                var_list_temp.add(a[i]);
	                    			//System.out.println(i + " " + a[i]);
	                    		}	
	                    	}
	                    }
	                }
	                else if(s.contains("Integer ") == true)
	                {
	                    //System.out.println(s);
	                    s=s.replaceAll(","," ");
	                    s=s.replaceAll("[^a-zA-Z0-9_]+"," ");
	                    a=s.split(" ");

	                    for(int i = 0;i<a.length;i++)
	                    {
	                    	if((a[i].trim().length() > 0) && !a[i].matches("[0-9]+") && !var_list_temp.contains(a[i]))// to check its not all whitespaces
	                    	{
	                    		if(!a[i].equals("Integer") && !a[i].equals("new") && !a[i].contains("Integer[") && !a[i].equals("=") && !Arrays.asList(keywords).contains(a[i]))
	                    		{
	                    			a[i] = a[i].replaceAll(";","");
	                    			Variable variable = new Variable();
	                                variable.name = a[i];
	                                variable.datatype = "Integer";
	                                var_list.add(variable);
	                                var_list_temp.add(a[i]);
	                    			//System.out.println(i + " " + a[i]);
	                    		}	
	                    	}
	                    }
	                }
	                else if(s.contains("String ") == true)
	                {
	                    //System.out.println(s);
	                    s=s.replaceAll(","," ");
	                    s=s.replaceAll("[^a-zA-Z0-9_]+"," ");
	                    a=s.split(" ");

	                    for(int i = 0;i<a.length;i++)
	                    {
	                    	if((a[i].trim().length() > 0) && !a[i].matches("[0-9]+") && !var_list_temp.contains(a[i])) // to check its not all whitespaces
	                    	{
	                    		if(!a[i].equals("String") && !a[i].equals("new") && !a[i].contains("String[") && !a[i].equals("=") && !Arrays.asList(keywords).contains(a[i]))
	                    		{
	                    			a[i] = a[i].replaceAll(";","");
	                    			Variable variable = new Variable();
	                                variable.name = a[i];
	                                variable.datatype = "String";
	                                var_list.add(variable);
	                                var_list_temp.add(a[i]);
	                    			//System.out.println(i + " " + a[i]);
	                    		}	
	                    	}
	                    }
	                }
	                else if(s.contains("char ") == true)
	                {
	                    //System.out.println(s);
	                    s=s.replaceAll(","," ");
	                    s=s.replaceAll("[^a-zA-Z0-9_]+"," ");
	                    a=s.split(" ");

	                    for(int i = 0;i<a.length;i++)
	                    {
	                    	if((a[i].trim().length() > 0) && !a[i].matches("[0-9]+") && !var_list_temp.contains(a[i])) // to check its not all whitespaces
	                    	{
	                    		if(!a[i].equals("char") && !a[i].equals("new") && !a[i].contains("char[") && !a[i].equals("=") && !Arrays.asList(keywords).contains(a[i]))
	                    		{
	                    			a[i] = a[i].replaceAll(";","");
	                    			Variable variable = new Variable();
	                                variable.name = a[i];
	                                variable.datatype = "char";
	                                var_list.add(variable);
	                                var_list_temp.add(a[i]);
	                    			//System.out.println(i + " " + a[i]);
	                    		}	
	                    	}
	                    }
	                }
	                
	      
	        
	                if(s.contains("="))
	                {
	                    String z[] = s.split(" ");
	                    String dt = null;
	                    for(int i = 0;i<z.length;i++)
	                    {
	                        if(z[i].trim().length() > 0)
	                        {
	                            //System.out.println(z[i]);
	                            if(var_list_temp.contains(z[i]))
	                            {

	                                for(int j = 0;j<var_list.size();j++)
	                                {

	                                    if(z[i].equals(var_list.get(j).name))
	                                    {
	                                        //System.out.println("Semantic error in line : " + line);
	                                        if(dt != null)
	                                        {   
	                                            if(!dt.equals(var_list.get(j).datatype))
	                                            {
	                                                System.out.println("Semantic error in line : " + line);
	                                          
	                                                out.println("Semantic error in line : " + line+"<br>");
	                                                var_list.get(j).datatype = dt;
	                                                System.out.println("(" + var_list.get(j).datatype + ")  " + var_list.get(j).name );
	                                                out.println("(" + var_list.get(j).datatype + ")  " + var_list.get(j).name +"<br>");
	                                            }
	                                        }
	                                        else
	                                        {
	                                            dt = var_list.get(j).datatype;
	                                      
	                                        }
	                                        break;
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }


	                       
	                for(int i = 0;i<complex_words.length;i++)
	                {
	                	if(s.contains(complex_words[i]))
	                		complexity++;
	                }
	                

	            }

	            
	            out.println("</div></div>");
	            
	            out.println("<div id=\"flip\" >Symbol Table</div><div id=\"panel\">");
	            
	            System.out.println("");

	            System.out.println("List of Variables used in the Program");
	            System.out.println();
	            System.out.println("Type-Int");
	            
	           out.println("<br>");

	          out.println("List of Variables used in the Program <br>");
	            out.println();
	           out.println("<br<br>Type-Int<br>");
	            
	            
	            for(int i = 0;i<var_list.size();i++){
	                if(var_list.get(i).datatype.equals("int"))
	                {     
	            	System.out.println(var_list.get(i).name + " " );
	               out.println(var_list.get(i).name + " <br>" );}
	            }
	            System.out.println();
	            System.out.println("Type-Float");
	            
	          out.println("<br<br>Type-Float");
	            for(int i = 0;i<var_list.size();i++){
	                if(var_list.get(i).datatype.equals("float"))
	                {     
	            	System.out.println(var_list.get(i).name + " " );
	            	out.println(var_list.get(i).name + "<br> " );}
	            }
	            System.out.println();
	            System.out.println(" Type-Double<br>");
	          out.println("<br> <br>Type-Double<br>");
	            for(int i = 0;i<var_list.size();i++){
	                if(var_list.get(i).datatype.equals("double"))
	                {     
	            	System.out.println(var_list.get(i).name + " " );
	            	out.println(var_list.get(i).name + "<br> " );}
	            }
	            System.out.println();
	            System.out.println("Type-Char<br>");
	            out.println("<br> <br>Type-Char<br>");
	            for(int i = 0;i<var_list.size();i++){
	                if(var_list.get(i).datatype.equals("char"))
	                {     
	            	System.out.println(var_list.get(i).name + " " );
	            	out.println(var_list.get(i).name + "<br> " );}
	            }
	            System.out.println();
	            System.out.println("<br> <br>Type-String<br>");
	          out.println("<br> <br>Type-String<br>");
	            for(int i = 0;i<var_list.size();i++){
	                if(var_list.get(i).datatype.equals("string"))
	                {     
	            	System.out.println(var_list.get(i).name + "<br> " );
	            	out.println(var_list.get(i).name + "<br> " );}
	            }
	            //System.out.println("Complexity of the Program  = " + complexity);
	            
	            out.println("</div></div>");
	        }
	        catch(Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
	        
	    	out.println("<body><html>");
	    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
