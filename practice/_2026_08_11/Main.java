package _2026_08_11;

class Response<T> {
    private T data;
    private boolean success;
    private String message;

    public Response(T data){
        this.data = data;
    }

    public T getT(){
        return this.data;
    }
}

public static void main(String[] args) {
    Response<String> str = new Response<String>("연습용");
    Response<Integer> Int = new Response<Integer>(11);

    System.out.println(str.getT() + " , " + Int.getT());

}

