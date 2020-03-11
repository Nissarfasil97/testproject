package com.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class TextReader 
{
	public static String name;
	public static String age;
	 public static void main(String[] args) throws Exception 
	 {
    	 String filePath = args[0];
    	 File file = new File("C:/Users/Nissar/eclipse-workspace/RuningJarWithVaiables/src/main/resources/"+filePath); 
    	 String st="";
    	  try (BufferedReader br = new BufferedReader(new FileReader(file))) 
    	  {
			ArrayList<String[]> al=new ArrayList<String[]>();
			  while ((st = br.readLine()) != null) 
				{
				  al.add(st.split(":"));
				}
			  
			  for(int i=0;i<al.size();i++)
			  { 
				  if(i==0)
				  {
					  name = al.get(0)[1];  
				  }
				  else
					  age = al.get(1)[1];
			  }
		} 
        Map<String,String> variableMap= fillMap();
 		Path path = Paths.get("C:/Users/Nissar/Desktop/myproject/common.txt");
 		Stream<String> lines;
 		try 
 		{
 			lines= Files.lines(path,Charset.forName("UTF-8"));
 		    List<String>replacedLines=lines.map(line -> replaceTag(line,variableMap)).collect(Collectors.toList());
 			 for (String commontext : replacedLines)
 			 {
 	            System.out.println(commontext);
 			 }
 		}
 			 catch(IOException e) 
 		{
 			e.printStackTrace();
 		}
 	}
 	public static Map<String,String>fillMap()
 	{
 		Map<String,String> map =  new HashMap<String,String>();
 		map.put("<%name%>",name);
 		map.put("<%age%>",age);
 		return map;
 	}
 	private static String replaceTag(String str,Map<String,String>map)
 	{
 		for(Map.Entry<String, String> entry : map.entrySet()) 
 		{
 			if (str.contains(entry.getKey()))
 			{
 				str = str.replace(entry.getKey(),entry.getValue());
 			}
 		}
 		return str;
 	}
}
 
 	

	 


