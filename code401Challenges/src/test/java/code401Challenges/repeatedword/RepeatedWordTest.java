package code401Challenges.repeatedword;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedWordTest {

    String theThirdPhilipic = "It is this fate, I solemnly assure you, that I dread for you, when the time comes that you make your reckoning, and realize that there is no longer anything that can be done. May you never find yourselves, men of Athens, in such a position! Yet in any case, it were better to die ten thousand deaths, than to do anything out of servility towards Philip [or to sacrifice any of those who speak for your good]. A noble recompense did the people in Oreus receive, for entrusting themselves to Philip’s friends, and thrusting Euphraeus aside! And a noble recompense the democracy of Eretria, for driving away your envoys, and surrendering to Cleitarchus! They are slaves, scourged and butchered! A noble clemency did he show to the Olynthians, who elected Lasthenes to command the cavalry, and banished Apollonides! It is folly, and it is cowardice, to cherish hopes like these, to give way to evil counsels, to refuse to do anything that you should do, to listen to the advocates of the enemy’s cause, and to fancy that you dwell in so great a city that, whatever happens, you will not suffer any harm.";
    String innaugurationAddress = "Can we forge against these enemies a grand and global alliance, North and South, East and West, that can assure a more fruitful life for all mankind? Will you join in that historic effort? In the long history of the world, only a few generations have been granted the role of defending freedom in its hour of maximum danger. I do not shrink from this responsibility — I welcome it. I do not believe that any of us would exchange places with any other people or any other generation. The energy, the faith, the devotion which we bring to this endeavor will light our country and all who serve it — and the glow from that fire can truly light the world. And so, my fellow Americans: ask not what your country can do for you — ask what you can do for your country. My fellow citizens of the world: ask not what America will do for you, but what together we can do for the freedom of man.";
    String socrates = "Some one will say: Yes, Socrates, but cannot you hold your tongue, and then you may go into a foreign city, and no one will interfere with you? Now I have great difficulty in making you understand my answer to this. For if I tell you that to do as you say would be a disobedience to the God, and therefore that I cannot hold my tongue, you will not believe that I am serious; and if I say again that daily to discourse about virtue, and of those other things about which you hear me examining myself and others, is the greatest good of man, and that the unexamined life is not worth living, you are still less likely to believe me.";

    @Test
    public void repeatedWordTest() {
        assertEquals("I", RepeatedWord.repeatedWord(theThirdPhilipic));
        assertEquals("and", RepeatedWord.repeatedWord(innaugurationAddress));
        assertEquals("you", RepeatedWord.repeatedWord(socrates));
    }
}