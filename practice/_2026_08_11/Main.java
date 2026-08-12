package _2026_08_11;

class Response<T> {
    private T data;
    private boolean success;
    private String message;

    public Response(T data, boolean success, String message){
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public T getData(){
        return this.data;
    }

    public boolean getSuccess(){
        return this.success;
    }

    public String getMessage(){
        return this.message;
    }
}
public class Main{
    public static void main(String[] args) {
        Response<String> str = new Response<String>("연습용", true, "박스 연습");
        Response<Integer> Int = new Response<Integer>(11, true, "박스 연습");

        System.out.println(str.getData() + " , " + Int.getData());
    }
}

