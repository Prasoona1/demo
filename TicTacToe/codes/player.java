package player;

public class Player {
    private String name, emailid;
    private int age;
    private String phoneno;
    private char symbol;

    public void setPlayerDetails(String name, String emailid, int age, String phoneno, char symbol) {
        this.name = name;
        this.emailid = emailid;
        this.age = age;
        this.phoneno = phoneno;
        this.symbol = symbol;
    }
    public void changeSymbol(char symbol){
        this.symbol=symbol;
    }

    public void setPlayerNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPlayerNameAgeEmailidSymbol(String name, int age, String emailid, char symbol) {
        this.name = name;
        this.age = age;
        this.emailid = emailid;
        this.symbol = symbol;
    }

    public void setPlayerNameAndSymbol(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return this.name;
    }

    public char getSymbol(){
        return this.symbol;
    }
    public void getPlayerNameandSymbol(){
        System.out.println("Player Name:"+this.name+" Player symbol:"+this.symbol);
    }
    public void getPlayerDetails(){
        System.out.println("Name of the player:"+this.name);
        System.out.println("Age:"+this.age);
        System.out.println("emailid:"+this.emailid);
        System.out.println("phoneno:"+this.phoneno);
        System.out.println("Symbol:"+this.symbol);
        System.out.println();
    }
}
