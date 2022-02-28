import com.company.interfaces.IListModifier;
import com.company.model.Rule;
import com.company.services.ListModifier;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestListModifier {
    private final IListModifier listModifier = new ListModifier();
    private final String str = "An :grinning:awesome :smiley:string &#128516;with few :wink:emojis!";
    private final String str1 = "Here is a boy: \uD83D\uDC66\uD83C\uDFFF!";


    @Test
    public void TestDefaultListModifier() {
        List<String> input = Arrays.asList(str, str1);
        listModifier.modifyList(input);
        String str2 = "An awesome string with few emojis!";
        String str3 = "Here is a boy: !";
        Assert.assertEquals(input, Arrays.asList(str2, str3));
    }

    @Test
    public void TestListModifierWithRules() {
        List<String> input = Arrays.asList(str, str1);
        listModifier.modifyList(input, new Rule(new HashSet<>(Arrays.asList("MyEmoji", "Vocabulary"))));
        String str2 = "An awesome string emojis!";
        String str3 = "Here is a : !";
        Assert.assertEquals(input, Arrays.asList(str2, str3));
    }

    @Test
    public void TestListModifierWithOneRule() {
        List<String> input = Arrays.asList(str, str1);
        listModifier.modifyList(input, new Rule(new HashSet<>(List.of("MyEmoji"))));
        String str2 = "An awesome string with few emojis!";
        String str3 = "Here is a boy: !";
        Assert.assertEquals(input, Arrays.asList(str2, str3));
    }


}
