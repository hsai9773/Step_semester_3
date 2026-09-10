package accessmodifiers.class_problems;

public class MovingBookingProfileTest {

    public static void main(String[] args) {

        MovingBookingProfile profile = new MovingBookingProfile("Sai");

        profile.setEmail("sai@gmail.com");
        profile.setAge(20);
        profile.setConfirmed(true);
        profile.setOtp("1234");

        System.out.println(profile.getName());
        System.out.println(profile.getEmail());
        System.out.println(profile.getAge());
        System.out.println(profile.isConfirmed());
    }
}