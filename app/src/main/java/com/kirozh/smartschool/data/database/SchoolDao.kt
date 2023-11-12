package com.kirozh.smartschool.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.kirozh.smartschool.data.models.Absence
import com.kirozh.smartschool.data.models.Lesson
import com.kirozh.smartschool.data.models.Mark
import com.kirozh.smartschool.data.models.Parent
import com.kirozh.smartschool.data.models.Student
import com.kirozh.smartschool.data.models.Subject
import com.kirozh.smartschool.data.models.Teacher
@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAbsence(absence: Absence)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertLesson(lesson: Lesson)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMark(mark: Mark)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertParent(parent: Parent)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeacher(teacher: Teacher)

    @Query("SELECT * FROM STUDENT where studentId = :studentId")
    fun getStudent(studentId: Int): Student?

    @Query("SELECT * FROM student WHERE login = :login")
    fun getStudentByLogin(login: String): Student?

    @Query("SELECT * FROM teacher where teacherId = :teacherId")
    fun getTeacher(teacherId: Int): Teacher?

    @Query("SELECT * FROM teacher WHERE login = :login")
    fun getTeacherByLogin(login: String): Teacher?

    @Query("SELECT * FROM parent WHERE parentId = :parentId")
    fun getParent(parentId: Int): Parent?

    @Query("SELECT * FROM parent WHERE login = :login")
    fun getParentByLogin(login: String): Parent?

    @Transaction
    @Query("SELECT * FROM parent JOIN student ON parent.studentId == student.studentId WHERE parent.studentId =:studentId")
    fun getStudentParents(studentId: Int): List<Parent>

    @Transaction
    @Query("SELECT * FROM student JOIN parent ON student.studentId == parent.studentId WHERE parent.parentId =:parentId")
    fun getParentStudent(parentId: Int): List<Student>

    @Transaction
    @Query("SELECT * FROM teacher JOIN subject ON teacher.subjectId == subject.subjectId WHERE teacher.teacherId = :teacherId")
    fun getTeacherSubjects(teacherId: Int): List<Subject>

    @Transaction
    @Query("SELECT * FROM subject JOIN teacher ON teacher.subjectId == subject.subjectId WHERE subject.subjectId = :subjectId")
    fun getSubjectTeachers(subjectId: Int): List<Teacher>

    @Transaction
    @Query("SELECT * FROM student JOIN mark ON student.studentId == mark.studentId WHERE student.studentId = :studentId")
    fun getStudentMarks(studentId: Int): List<Mark>

    @Transaction
    @Query("SELECT * FROM student JOIN mark ON student.studentId == mark.studentId WHERE student.studentId = :studentId AND mark.subjectId = :subjectId")
    fun getStudentMarksForSubject(studentId: Int, subjectId: Int): List<Mark>

    @Transaction
    @Query("SELECT * FROM mark WHERE lessonId = :lessonId")
    fun getLessonMarks(lessonId: Int): List<Mark>

    @Transaction
    @Query("SELECT * FROM absence JOIN student ON absence.studentId == student.studentId WHERE absence.studentId = :studentId")
    fun getStudentAbsences(studentId: Int): List<Absence>
    @Transaction
    @Query("SELECT * FROM lesson JOIN ClassNumber ON lesson.classNumberId == ClassNumber.classNumberId JOIN student ON student.classNumberId == ClassNumber.classNumberId WHERE student.studentId = :studentId")
    fun getStudentLessons(studentId: Int): List<Lesson>

    @Transaction
    @Query("SELECT * FROM lesson Join teacher ON lesson.teacherId == teacher.teacherId WHERE teacher.teacherId = :teacherId")
    fun getTeacherLessons(teacherId: Int): List<Lesson>
}