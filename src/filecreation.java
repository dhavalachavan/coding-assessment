import java.io.*;


public class filecreation {

	
	public static void main(String[] args) throws IOException {
	    
		boolean status;
	    
		/* Step1:Create a new folder*/
		 
		String Step1 = "C:/Users/Ankit/Desktop/myfolder3";
		
		status = new File(Step1).mkdir();
		
		/*Step 2: Create a new file */
		if(status) {
			status = new File ("C:/Users/Ankit/Desktop/myfolder3/myfile.txt").createNewFile();
		}
 
		/*Step3:Add content to a file.FileNotFound exception handled */
	
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
	    /*Step4: Copy from source file to destination file*/
	    try{
	    	  File f1 = new File("C:/Users/Ankit/Desktop/myfolder1/myfile.txt");
	    	  File f2 = new File("C:/Users/Ankit/Desktop/myfolder3/myfile.txt");
	    	  FileInputStream in = new FileInputStream(f1);
	    
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
	    
	 /*Step 5 : Display file contents*/   
         BufferedReader in = new BufferedReader(new FileReader("C:/Users/Ankit/Desktop/myfolder3/myfile.txt"));

          String line;
           while((line = in.readLine()) != null)
         {
           System.out.println(line);
           }
          in.close();

     /*Step 6 : List all the folder contents.Will print if contents are files or directories*/
         File f = new File("C:/Users/Ankit/Desktop"); // current directory

            File[] files = f.listFiles();
         for (File file : files) {
	     if (file.isDirectory()) {
		 System.out.print("directory:");
	     } else {
		  System.out.print("     file:");
	   }
	  
	 /*Step 7 & 8: The 'findFile' method will take the input parameters(filename/absolute path) to find it*/
	   
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