public class Book {
    private String title="";
    private String author="";
    private String tableOfContents ="";
    private int nextPage = 1;

    public Book(String s1, String s2) {
        this.title = s1;
        this.author = s2;
    }

    public void addChapter(String s1, int n1) {
        tableOfContents = tableOfContents + "\n" + s1 + "..." + nextPage;
        nextPage = nextPage + n1;
    }

    public int getPages() {
        return nextPage -1;
    }

    public String getTableOfContents() {
        return tableOfContents;
    }

    public String toString() {
        return title + "\n" + author;
    }
}
