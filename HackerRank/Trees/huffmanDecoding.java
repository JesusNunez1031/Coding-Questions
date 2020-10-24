public class huffmanDecoding {
    /*
        Huffman coding assigns variable length codewords to fixed length input characters based on their frequencies.
        More frequent characters are assigned shorter codewords and less frequent characters are assigned longer codewords.
        All edges along the path to a character contain a code digit. If they are on the left side of the tree, they will be a 0 (zero).
        If on the right, they'll be a 1 (one). Only the leaves will contain a letter and its frequency count. All other nodes will
        contain a null instead of a character, and the count of the frequency of all of it and its descendant characters.
     */
    void decode(String s, Node root) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Node iter = root;

        while (i < s.length()) {
            //if the char value is a 0, we move left from the root node
            if (s.charAt(i) == '0') {
                iter = iter.left;
                //if the char value is 1, we move right from the root node
            } else if (s.charAt(i) == '1') {
                iter = iter.right;
            }
            //once our iter pointer has moved, if it is not at a null character, we have decoded a segment, append its value to the result and return the pointer back to the root
            if (iter.data != '\0') {
                sb.append(iter.data);
                iter = root;
            }
            i++;
        }
        System.out.printf("%s", sb.toString());
    }
}
