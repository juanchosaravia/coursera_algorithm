package week1;

import org.junit.Assert;
import org.junit.Test;
import week1.optionals.SocialNetwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author juancho
 */
public class SocialNetworkTest {

    private static final String FILE_PATH = "./resources/";
    private static final Pattern pattern = Pattern.compile("[ ]*(\\d+)+[ ]*(\\d+)+[ ]*(\\d+)+");

    @Test
    public void simpleTest() throws IOException {
        int size;
        SocialNetwork socialNetwork;
        double timestamp = 0;
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + "social_network.txt"))) {
            String line;
            if ((line = br.readLine()) != null) {
                size = Integer.parseInt(line);
                socialNetwork = new SocialNetwork(size);
                while ((line = br.readLine()) != null) {
                    // process the line.
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches() && matcher.groupCount() > 2) {
                        socialNetwork.addFriendship(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                        if (socialNetwork.areAllFriendsConnected() && !found) {
                            found = true;
                            timestamp = Double.parseDouble(matcher.group(3));
                        }
                    }
                }
            }
        }

        Assert.assertEquals(1478389642826D, timestamp, 1478389642826D - timestamp);
    }
}
