public class URLify {

    //Replace spaces in a string with '%20'

    //Using pre-built java methods
    public static String urlify(String str) {
        String str2 = str.replaceAll(" ", "%20");
        return str2;
    }

    // Book solution; Use two scans, in the first we count the number of spaces and then we triple the count since we are replacing spaces with 3 new characters "%20"
    public static void replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0, index, i = 0;
        for(i = 0;i < trueLength;i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2;
        if(trueLength < str.length)
            str[trueLength] = '\0'; //End of the array
        for(i = trueLength-1; i >= 0;i--){
            if(str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        char[] arr = "Mr John Smith is the best example".toCharArray();
        replaceSpaces(arr, arr.length);

        //System.out.print(urlify("Mr John Smith is the best example"));
    }
}
