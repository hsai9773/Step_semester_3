package accessmodifiers.assignment_problems.javabean;

public class LibraryMemberTest {

    public static void main(String[] args) {

        LibraryMember member = new LibraryMember();

        member.setMembershipId("LIB101");
        member.setMembershipId("LIB202");

        member.setName("Sai");
        member.setPremiumMember(true);
        member.setSecurityAnswer("tiger");

        System.out.println(member.getMembershipId());
        System.out.println(member.getName());
        System.out.println(member.isPremiumMember());
    }
}