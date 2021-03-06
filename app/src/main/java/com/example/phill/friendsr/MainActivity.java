// Philline Dikker: 12317608
// Week 3: Friendsr


package com.example.phill.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // an ArrayList of sample friends since we are storing friends- objects
        ArrayList<Friend> friends = new ArrayList<>();

    // make all friends
    Friend actor1 = new Friend("Arya","Arya Stark is the third child and second daughter of Lord Eddard Stark and his wife, Lady Catelyn Stark. After narrowly escaping the persecution of House Stark by House Lannister, Arya is trained as a Faceless Man at the House of Black and White in Braavos, and uses her new skills to bring those who have wronged her family to justice.", getResources().getIdentifier("arya","drawable",MainActivity.this.getPackageName()));
    Friend actor2 = new Friend("Cersei"," Queen Cersei I Lannister is the widow of King Robert Baratheon, with whom she had her sole trueborn child, and Queen of the Seven Kingdoms. She is the daughter of Lord Tywin Lannister, twin sister of Jaime Lannister and elder sister of Tyrion Lannister. She had an incestuous relationship with Jaime, who is secretly the father of her three bastard children, Joffrey, Myrcella and Tommen.", getResources().getIdentifier("cersei","drawable",MainActivity.this.getPackageName()));
    Friend actor3 = new Friend("Jaime","Ser Jaime Lannister is the eldest son of Tywin, younger twin brother of Cersei, and older brother of Tyrion Lannister. He was involved in an incestuous relationship with Cersei, and unknown to most, he is the biological father of her three children, Joffrey, Myrcella, and Tommen.", getResources().getIdentifier("jaime","drawable",MainActivity.this.getPackageName()));
    Friend actor4 = new Friend("Jon","Jon Snow, born Aegon Targaryen, is the son of Lyanna Stark and Rhaegar Targaryen, the late Prince of Dragonstone. From infancy, Jon is presented as the bastard son of Lord Eddard Stark, Lyanna's brother, and raised by Eddard alongside his lawful children at Winterfell but his true parentage is kept secret from everyone, including Jon himself. In order to escape his bastard status, Jon joins the Night's Watch and is eventually chosen as Lord Commander. However, he is later murdered in a mutiny and resurrected by the Red Priestess Melisandre. Freed from his Night's Watch vows, Jon joins his cousin, Sansa Stark, in building an army and together they retake Winterfell from House Bolton, restoring House Stark's dominion over the North with Jon being declared the new King in the North. However, after successfully capturing a wight and presenting it to the Lannisters as proof that the Army of the Dead is real, Jon pledges himself and his army to Daenerys Targaryen, Rhaegar's sister, and steps down as King of the North. ", getResources().getIdentifier("jon","drawable",MainActivity.this.getPackageName()));
    Friend actor5 = new Friend("Jorah","Ser Jorah Mormont is a formerly exiled Northern lord from Westeros previously living in Essos. He has sworn fealty to his fellow exile Daenerys Targaryen and was the first to help her adapt to life as a Khaleesi of the Dothraki.\n" +
            "\n" +
            "Originally, Jorah was working as a spy for Varys, King Robert's spymaster in King's Landing, sending Varys information about the Targaryen exiles. But he grows to respect and admire Daenerys and begins serving her in earnest. He saves her from an assassination attempt, stops sending reports to Varys and ignores an official royal pardon that would allow him to return home to Westeros. He develops strong and unrequited feelings for her. ", getResources().getIdentifier("jorah","drawable",MainActivity.this.getPackageName()));
    Friend actor6 = new Friend("Margaery","Queen Margaery Tyrell was the only daughter of Lord Mace Tyrell and Lady Alerie Tyrell, granddaughter of Lady Olenna Tyrell and sister of Ser Loras Tyrell. Margaery became Queen Consort through her marriage to King Joffrey Baratheon, and later his younger brother, King Tommen Baratheon, following Joffrey's death. However, her desire to become Queen, ultimately proved to be her downfall as she was eventually killed along with her brother and father when the Great Sept of Baelor was destroyed with wildfire as orchestrated by Cersei Lannister to reclaim her lost power.", getResources().getIdentifier("margaery","drawable",MainActivity.this.getPackageName()));
    Friend actor7 = new Friend("Melisandre","Melisandre, often referred to as the Red Woman, is a Red Priestess in the religion of R'hllor, the Lord of Light, and a close counselor to Stannis Baratheon in his campaign to take the Iron Throne. After Stannis Baratheon's death at the Battle of Winterfell, she revives Jon Snow after he is murdered by various members of the Night's Watch, believing him to be The Prince That Was Promised, and serves Jon as an adviser until she is banished from the North after the Battle of the Bastards when Jon learns that she sacrificed Shireen Baratheon and countless innocent people while in Stannis's service. However, she later unites the newly crowned King in the North with Daenerys Targaryen, believing they both have an important part to play in the Great War.", getResources().getIdentifier("melisandre","drawable",MainActivity.this.getPackageName()));
    Friend actor8 = new Friend("Sansa","Lady Sansa Stark is the eldest daughter of Lord Eddard Stark of Winterfell and his wife Lady Catelyn, sister of Robb, Arya, Bran and Rickon Stark, and \"half-sister\" of Jon Snow.", getResources().getIdentifier("sansa","drawable",MainActivity.this.getPackageName()));
    Friend actor9 = new Friend("Tyrion","Lord Tyrion Lannister is the youngest child of Lord Tywin Lannister and younger brother of Cersei and Jaime Lannister. A dwarf, he uses his wit and intellect to overcome the prejudice he faces.\n" +
            "\n" +
            "His abduction by Catelyn Stark for a crime he did not commit serves as one of the catalysts of the War of the Five Kings. After escaping his captors, Tyrion is appointed by his father as acting Hand of the King to Joffrey Baratheon and successfully defends King's Landing against Stannis Baratheon at the Battle of the Blackwater, after which he is stripped of his power, demoted to Master of Coin and eventually framed for Joffrey's murder. After his champion, Oberyn Martell, dies in Tyrion's trial by combat, Tyrion flees to Essos with help from Jaime and Varys after murdering his father.", getResources().getIdentifier("tyrion","drawable",MainActivity.this.getPackageName()));

    // adding al friends
    friends.add(actor1);
    friends.add(actor2);
    friends.add(actor3);
    friends.add(actor4);
    friends.add(actor5);
    friends.add(actor6);
    friends.add(actor7);
    friends.add(actor8);
    friends.add(actor9);

    //    instantiate your adapter
    FriendsAdapter adapter = new FriendsAdapter(this,R.layout.grid_item, friends   );

    // attach the adapter to GridView
    GridView gridView = findViewById(R.id.gridView);
    gridView.setAdapter(adapter);
    gridView.setOnItemClickListener(new GridItemClickListener());

    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long ID){

//            connect this listener to the GridView
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(position);

//           intent to  pass this information to the next activity : Profile Activity
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend_key", clickedFriend);
            startActivity(intent);
        }

    }
}
