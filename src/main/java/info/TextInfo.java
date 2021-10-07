package info;

public class TextInfo {
    private static TextInfo textInfo = null;

    public static TextInfo getTextInfo() {
        if (textInfo == null){
            textInfo = new TextInfo();
        }
        return textInfo;
    }

    public TextInfo() {
    }




    public void infoShow() {
        System.out.println("Enter operation...\n" +
                "1 - show all courses.\n" +
                "2 - show all students.\n" +
                "3 - show all teachers.\n" +
                "4 - show course by id.\n" +
                "5 - show student by id. \n" +
                "6 - show teacher by id.\n" +
                "7 - show all students from the same course by id.\n" +
                "8 - show all courses of one student by id. \n" +
                "9 - show teachers of one course by id. \n" +
                "10 - exit to menu.");
    }

    public void infoMenu() {
        System.out.println("Enter operation...\n" +
                "1 - show operations.\n" +
                "2 - adding operations.\n" +
                "3 - deletion operations.\n" +
                "4 - update operations. \n" +
                "5 - exit.");
    }


    public void infoAdding(){
        System.out.println("Enter operation...\n" +
                "1 - add a course. \n" +
                "2 - add a student to the course. \n" +
                "3 - add a teacher to the course \n" +
                "4 - change the teacher on the course.\n" +
                "5 - exit to menu.");
    }

    public void infoDeletion(){
        System.out.println("Enter operation...\n" +
                "1 - delete course by id.\n" +
                "2 - delete student by id.\n" +
                "3 - delete teacher by id.\n" +
                "4 - delete a student on the course.\n" +
                "5 - delete all students in the course.\n" +
                "6 - delete a teacher on a course.\n" +
                "7 - delete a course from a student.\n" +
                "8 - exit to menu...\n");
    }

    public void infoUpdate(){
        System.out.println();
    }
}
