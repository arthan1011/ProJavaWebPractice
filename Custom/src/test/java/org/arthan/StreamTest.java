package org.arthan;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by Артур on 07.08.2015.
 * Next to Ufa.
 */
public class StreamTest {

    @Test
    public void testModification() throws Exception {
        List<StringBuilder> stringBuilderList = Lists.newArrayList(
                new StringBuilder("D_"),
                new StringBuilder("M_"),
                new StringBuilder("E_")
        );

        System.out.println("List before modification: " + stringBuilderList);

        stringBuilderList.stream()
                .forEach(sb -> sb.append("k"));

        System.out.println("List after modification: " + stringBuilderList);
    }
}
