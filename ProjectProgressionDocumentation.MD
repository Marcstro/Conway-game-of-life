So, since we only have an afternoon to complete this project I don't think I'll have enough time to complete it. Althought I've done similar little fun graphical things on my own in the past.
So I will document my time building this project, to give an insight into how I've tried to deal with the problem and how I planned to solve it. So even if I don't end up finishing it there will still be quite some insight into how I attempt to solve these kinds of tasks.

Right away I vaguely determine I will divide this game into five parts.
1. create a graphical window to display the squares, and besides it another graphical window containing possible buttons.
2. create an actual grid on my graphical window, test if I can adjust what squares are displayed as active/inactive.
3. Make a timer that will continously "ping" my graphical window, telling it to do stuff (each new ping will be another cycle of the game).
4. Make logical things that determines what squares to activate/inactivate.
5. This is a maybe and I likely won't make it this far in time: Create buttons on my right graphical window for "start/stop", possibly make all squares touchable which would turn them active/inactive.


Time displayed in hour - minutes

0:0 google how does jframe/jlabel and all those graphical things work again

0:10 Got a window up, added JLabels to it and... they refuse to show up.. hrm...

0:15 Nevermind, setting a background color doesn't actually make a JLabel that colour

0:18 Aha, yes it did. I had to label.setOpaque(true);

0:40 took a short breather, came back and I got 2 JLabels (2 windows) up and running. Quickly added start/stop button to my thin right one (that I call ButtonLabel). My left one is my large square grid where I'll display the squares, it's called "grid".

step 1 is complete

0:55 Hey that wasn't that hard. In my label I got a paintcomponent, in which I do two for-loops, one for vertical and one for horizontal, and draw rectangels to make a grid. 


0:59 I did a little

int r = (int)(Math.random()*10);
                    if(r==5){
                        g.setColor(java.awt.Color.black);
                        g.fillRect((horizontal*squareSize), (vertical*squareSize), squareSize, squareSize);
                    }

so that 1/10 of the square would become solid black and it worked quite well.

step 2 is complete

1:05 how does threads work again? Something about Thread thread = new Thread and then thread.run or something. To the google-mobile

1:20 Allright,  my main program will be my "engine", continously calling to change the squares. I found out about the "timer"-function and am testing it.

1:22 wait no that's stupid. I make an engine class

1:25 okey I got an engine up and going. At the moment all it does is type the amount of seconds that has passed since the program has begun. but good enough. I will make a new class called "Square", each square on my grid will be linked to a square-object that contain's the squares coordinates, if it's active or not, if it's going to be deactivated or not. My graphical label will contain an array[][] to hold them all.

1:35 I make a "do stuff" method in my label class that when "reached" will activate a random square, I'll set my engine to reach it once a second

1:52 DAMN, sometime during coding I must've accidentally changed my PaintComponent from filling rectangles to just drawing them, leading to black squares not filling up. Spent 15 minutes trying to debug why my above described function refused to work. But now it does! Every second one more square turns black, unless it was already black, in case it turns white. 

Step 3 complete.

1:58 My grid-class will get a tick() method. It will run through EVERY square and do the checking amount of active squares around it, then put that square into "activate", "deactivate", or just nothing, -state. After the loop has gone through all squares, it will do so again but this time activate those marked activate and likewise for deactivate.

Edit: my loop will NOT go through the bottom/top/left/right row. Those will be my clear edges to the "field".

Interesting note: I kept my program that randomly disables/enables squares running. Eventually it will reach a state of equilibrium (same amount of blacks and whites). I think you can calculate the approx. time that will take, I should do that later for fun.

2:12 First attempt done with the logic stuff, now testing. I set my grid to begin with a few active squares

2:20 Uhh... my program works for 1 iteration of the tick().... debugg time.

2:45 DAMNIT again. Apparently when i checked every squares 8 neighbours I wrote my for-loop:

i=x-1; i<x+1

which means it will go through x-1 and x, not x+1. That took me some time to figure out. Doing testing with what wikipedia examples and I see if my figures work as wikipedia shows they work.

2:50 AHA, success! Simple 2x2 squares and a squiggly moving thing both work. 

Step 4 done.

Okay now I need actionListener. I'll make a new class for that, and through my primary graphic frame throw the listener onto my buttons and on the grid.

Uhh I just realised It's been way too long since I last did a separate class as a listener. I'll just implement actionlistener through my main graphical window.

I apparently need mouseListener for my grid-label, no biggie

3:20	I got function for all my buttons, start, stop, faster, slower. Default iteration/tick speed is 0,6 seconds. Changing by 0,2 every time you change speed.

3:40 	okay apparently adjusting the speed settings turned out to be WAY harder than expected, given my amount of time. I focused instead on building a clickable grid.. which took only 2 minutes. So...

Part 5 completed.

Okay I actually had time for this speed thing

3:58 I've got speed adjusting up to date, along with a little window showing how fast my program is running.

Removed some comments, some checking up stuff.

I realised a little fault.

The slow/speed up function automatically turns the program on, even if it's paused.

But my 4 hours have passed and I'm calling it a night.

