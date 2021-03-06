package wiredsharp.study.api.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RegisterForReflection
public class School {

   public Long id;
   public String name;

   public List<Student> students;

   public School(Long id, String name, Iterable<Student> students) {
      super();
      this.id = id;
      this.name = name;
      this.students = StreamSupport.stream(students.spliterator(), false).collect(Collectors.toList());
   }

   public School(String name) {
      this.name = name;
      this.students = new ArrayList<Student>();
   }

   public static School from(wiredsharp.study.model.School school) {
      return new School(school.id, school.name, school.students.stream()
         .map(Student::from).collect(Collectors.toList()));
   }
}
