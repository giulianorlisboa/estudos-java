void main(){

    String path = "c:\\temp\\in.txt";
    FileReader fr = null;
    BufferedReader br = null;

    try {
        fr = new FileReader(path);
        br = new BufferedReader(fr);

        String line = br.readLine();

        while (line != null) {
            IO.println(line);
            line = br.readLine();
        }
    } catch (IOException e) {
        IO.println("error: " + e.getMessage());
    }
    finally{
        try {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
        }catch (IOException e){
            e.printStackTrace();
            IO.println("error: " + e.getMessage());
        }
    }
}