package com.example.homemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Animals extends AppCompatActivity {

    int all_ctr = 0, id = 0;
    ImageButton next,back,speaker,sound,exit;
    ImageView wordimg;
    TextView desc;
    String[] filename = {"Bird","Bear","Crocodile","Eagle","Elephant","Giraffe","Hyena","Iguana","Kangaroo","Cheetah",
            "Lion","Monkey","Ostrich","Owl","Panda","Peacock","Snake","Tiger","Turtle","Zebra"};
    String[] description = {"Birds are warm-blooded vertebrates (vertebrates have backbones) and are the only animals with feathers. Although all birds have wings, a few species can't fly.",
    "Bears are large mammals that drink their mother's milk as babies and have fur. They also have a snout and short, stubby tails. The smallest bears are sun bears and weigh about a hundred pounds, while polar bears are the largest and can weigh over 1,500 pounds! That's about the same as three large male lions.",
    "Crocodiles have very pointed snouts, and their upper and lower jaws are the same size. Crocodiles have webbed feet, which help them to be fast swimmers. Their bodies are also very streamlined, which means that they can slide quickly through the water to catch their prey.",
    "Eagles are large, powerful birds of prey. Eagles have large, hooked beaks. Eagles have excellent eyesight. Eagles have powerful talons which help them catch prey.",
    "Elephants are known for their large ears, tusks made of ivory and their trunks – which are actually a fusion of their nose and upper lip. 2) Elephants are the world's largest land animal! Male African elephants can reach 3m tall and weigh between 4,000 -7,500kg.",
    "Giraffe have spots, very long legs, and long necks. They have hair-covered horns on their heads called ossicones, which protect them when they fight. Giraffes are herbivores, meaning they only eat plants, and they use their long necks and tongues to reach their favorite foods.",
    "Hyenas are a type of animal called a mammal. Mammals are animals that have fur, are warm-blooded, and give birth to live babies. Hyenas are large animals and can weigh up to 190 pounds, which is the size of a large grown up human. They have front legs that are longer than their back legs and really big ears.",
    "Most iguanas are green. Many have unusual sawlike teeth. They also have a scaly back and a fold of skin under the neck. The male common iguana grows up to 6.5 feet (2 meters) long and weighs up to 13 pounds (6 kilograms).",
    "Kangaroos possess powerful hind legs, a long, strong tail, and small front legs. Kangaroos belong to the animal family Macropus, literally \"big foot.\" Thanks to their large feet, kangaroos can leap some 30 feet (9 meters) in a single bound, and travel more than 30 miles (48 kilometers) per hour.",
    "Cheetahs are slender athletic cats, much smaller than lions and tigers. They look a bit like leopards, but are much leaner with round spots. They have slim, muscular long legs, flexible spine and a small round head, all of which help them run very fast. At the shoulder, an adult cheetah stands around 30 inches tall.",
    "Lions have strong, compact bodies and powerful forelegs, teeth and jaws for pulling down and killing prey. Their coats are yellow-gold, and adult males have shaggy manes that range in color from blond to reddish-brown to black.",
    "Monkeys are mostly omnivores and eat fruit, leaves, nuts and insects. All species of monkeys have opposable thumbs just like humans. Monkeys live both on the ground and in trees. Monkeys that spend their entire lives in trees are called arboreal.",
    "The ostrich is a large flightless bird that lives in Africa. They are the largest living bird species, and have the biggest eggs of all living birds. Ostriches do not fly, but can run faster than any other bird. They are ratites, a useful grouping of medium to large flightless birds.",
    "Owls have round faces and huge eyes, which make them look oddly human. They need good hearing and eyesight to find prey in dim light. Unlike most other birds, the owl's eyes face forwards, which means they can judge distances more accurately.",
    "Panda are peaceful animals have rounded faces and almost look like they're smiling. Pandas live in the mountains and forests of China. Chinese people have loved them for thousands of years. Giant Pandas have rounded faces and almost look like they're smiling.",
    "Peacocks are large, male birds that can lift up their long, colorful tails, spreading them open like a fan. They and female peacocks, called peahens, can also fly. Peahens are much more plain looking so they can hide and protect their eggs that hatch into peachicks.",
    "A snake is a reptile with a long, thin body but no legs. Some lizards are legless and look like snakes, however, most lizards have eyelids, and snakes do not. All snakes eat live prey, which is grabbed and swallowed whole without chewing it into pieces.",
    "Easily recognized by its coat of reddish-orange with dark stripes, the tiger is the largest wild cat in the world. The big cat's tail is three feet long. On average the big cat weighs 450 pounds, about the same as eight ten-year-old kids.",
    "A turtle is a reptile that has a shell covering its body. Turtles are known for moving very slowly. There are more than 350 species, or types, of turtle. Turtles are found in most parts of the world.",
    "Zebras have black fur with white stripes and predominantly white bellies. Their feet are capped with a singular, hard hoof, which packs a punch when kicked at predators. They have large, rounded ears with lots of hair to keep dust out of them."};
    MediaPlayer ai;

    private int CurrentProgress = 1;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        exit = findViewById(R.id.exit);
        desc = findViewById(R.id.Desc);
        speaker = findViewById(R.id.speaker);
        sound = findViewById(R.id.sound);
        wordimg = findViewById(R.id.WordImg);

        id = setImg();
        wordimg.setImageResource(id);
        desc.setText(description[all_ctr]);

        progressBar = findViewById(R.id.ProgressBar); // need ito para sa progress
        progressBar.setMax(20);
        progressBar.setProgress(CurrentProgress);

        back.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                all_ctr--;
                id = setImg();
                wordimg.setImageResource(id);
                desc.setText(description[all_ctr]);
                CurrentProgress = CurrentProgress + 1;
                progressBar.setProgress(CurrentProgress);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                stopPlaying();
                if(all_ctr < 19) {
                    all_ctr++;
                    id = setImg();
                    wordimg.setImageResource(id);
                    desc.setText(description[all_ctr]);
                    CurrentProgress = CurrentProgress + 1;
                    progressBar.setProgress(CurrentProgress);
                } else {
                    Intent intent = new Intent(Animals.this,EndPage.class);
                    intent.putExtra("Type","Animals");
                    startActivity(intent);
                }
            }
        });

        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                Resources res = getResources();
                int sound = res.getIdentifier(filename[all_ctr].toLowerCase(), "raw", getPackageName());
                ai = MediaPlayer.create(Animals.this, sound);
                ai.start();
            }
        });

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                Resources res = getResources();
                int sound = res.getIdentifier(filename[all_ctr].toLowerCase() + "1", "raw", getPackageName());
                ai = MediaPlayer.create(Animals.this, sound);
                ai.start();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                finish();
            }
        });

    }

    public int setImg(){
        Resources res = this.getResources();
        int resID;
        return resID = res.getIdentifier(filename[all_ctr].toLowerCase(), "drawable", this.getPackageName());
    }

    protected void stopPlaying(){
        // If media player is not null then try to stop it
        if(ai!=null){
            ai.stop();
            ai.release();
            ai = null;
        }
    }
}