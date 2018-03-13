import fetcher.YoutubeVideoUrlFetcher;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TestYoutubeVideoUrlFetcher {
  static String html;

  @BeforeAll
  public static void setup() throws IOException {
    TestYoutubeVideoUrlFetcher.html = FileUtils.readFileToString(new File("src/test/resources/youtube-search-test.html"), "UTF-16");
  }

  @Test
  public void FetchingUrlFromValidHtmlShouldYieldUrl() {
    Assert.assertTrue(new YoutubeVideoUrlFetcher().fetchUrlFromHtml(TestYoutubeVideoUrlFetcher.html) == "youtube.com/watch?v=tpLLst4-3fw");
  }
}