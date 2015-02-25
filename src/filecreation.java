import java.io.*;


public class filecreation {

	
	public static void main(String[] args) throws IOException {
	    
		boolean status;
	    
		/* Step1 
		 */
		String Step1 = "C:/Users/Ankit/Desktop/myfolder3";
		
		status = new File(Step1).mkdir();
		if(status) {
			status = new File ("C:/Users/Ankit/Desktop/myfolder3/myfile.txt").createNewFile();
		}

	
	//static void report(boolean status){
		//System.out.println(status);
	//}
	
	
	    try
	    {
	        String path = "C:/Users/Ankit/Desktop/myfolder3/myfile.txt";

	        File file = new File(path);

	        FileOutputStream fs = new FileOutputStream(file,true);

	        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(fs));

	        bw.append("Sample text in the file to append");

	        bw.close();

	        System.out.println("User Registration Completed");

	    }catch(Exception ex)
	    {
	        System.out.println(ex);
	    }
	    
	    try{
	    	  File f1 = new File("C:/Users/Ankit/Desktop/myfolder1/myfile.txt");
	    	  File f2 = new File("C:/Users/Ankit/Desktop/myfolder3/myfile.txt");
	    	  FileInputStream in = new FileInputStream(f1);
	    	  
	    	  //For Append the file.
	    	//  OutputStream out = new FileOutputStream(f2,true);

	    	  //For Overwrite the file.
	    	  OutputStream out = new FileOutputStream(f2);

	    	  byte[] buf = new byte[1024];
	    	  int len;
	    	  while ((len = in.read(buf)) > 0){
	    	  out.write(buf, 0, len);
	    	  }
	    	  in.close();
	    	  out.close();
	    	  System.out.println("File copied.");
	    	  }
	    	  catch(FileNotFoundException ex){
	    	  System.out.println(ex.getMessage() + " in the specified directory.");
	    	  System.exit(0);
	    	  }
	    	  catch(IOException e){
	    	  System.out.println(e.getMessage());  
	    	  }
	    
	    


          BufferedReader in = new BufferedReader(new FileReader("C:/Users/Ankit/Desktop/myfolder3/myfile.txt"));

//Then, you can use in.readLine(); to read a single line at a time. To read until the end, write a while loop as such:

          String line;
           while((line = in.readLine()) != null)
         {
           System.out.println(line);
           }
          in.close();



         File f = new File("C:/Users/Ankit/Desktop"); // current directory

            File[] files = f.listFiles();
         for (File file : files) {
	     if (file.isDirectory()) {
		 System.out.print("directory:");
	     } else {
		  System.out.print("     file:");
	   }
	   System.out.println(file.getCanonicalPath());
	   
	   String fn = "myfile.txt";
	    File dir = new File("C:/Users/");
        findFile(fn,dir);

         }
	}
	
	public static void findFile(String name,File file)

    {

        File[] list = file.listFiles();

        if(list!=null)

        for (File fil : list)

        {

            if (fil.isDirectory())

            {

                findFile(name,fil);

            }

            else if (name.equals(fil.getName()))

            {

                System.out.println(fil.getParentFile() + "/" + fil.getName());

            }

        }

    }
	
}