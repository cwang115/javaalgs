package suanfageTree;

public class Trie {
    public TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c-'a'] = new TrieNode();
                int index = c - 'a';
                System.out.printf("c - 'a'" , index);
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c- 'a'];
        }
        if(node.item.equals(word)){
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("word");

    }
}
