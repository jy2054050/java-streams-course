package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    List<Person> peopleBelow18 = new LinkedList<>();
    int limit = 10;
    int counter = 0;
    for (Person p : people){
      if(p.getAge() <= 18) {
        peopleBelow18.add(p);
        counter ++ ;
        if(counter == limit) break;
      }
    }
    System.out.println(peopleBelow18);
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    MockData.getPeople().stream()
            .filter(people -> people.getAge() <= 18)
            .limit(10)
            .collect(Collectors.toList())
            .forEach(System.out::println);
  }
}
