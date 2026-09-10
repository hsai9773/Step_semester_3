package accessmodifiers.class_problems;

public class MovingBookingProfile {

    private String name;
    private String email;
    private int age;
    private boolean confirmed;
    private String otp;

    public MovingBookingProfile() {
    }

    public MovingBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        if (otp != null && otp.matches("\\d{4,6}")) {
            this.otp = otp;
        }
    }
}