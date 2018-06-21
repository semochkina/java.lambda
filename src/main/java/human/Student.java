package human;

import human.Human;

public class Student extends Human {

    private String university;
    private String faculty;
    private String specialty;

    public Student(String name, String surname, String patronymic, int age, Gender gender, String university, String faculty, String specialty) {
        super(name, surname, patronymic, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        human.Student student = (human.Student) o;
//
//        if (university != null ? !university.equals(student.university) : student.university != null) return false;
//        if (faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) return false;
//        return specialty != null ? specialty.equals(student.specialty) : student.specialty == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + (university != null ? university.hashCode() : 0);
//        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
//        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
//        return result;
//    }
}
