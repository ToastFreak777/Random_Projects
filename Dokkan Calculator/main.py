from tkinter import *
from tkinter import messagebox
from tkinter import simpledialog
from PIL import Image, ImageTk


class App(Tk):
    WIDTH, HEIGHT = 500, 240

    def __init__(self) -> None:
        super().__init__()

        # Calculator variables
        self.ki = self.total_hp = int()
        self.leaderskill = {
            "player": {"hp": int(), "attack": int(), "defense": int()},
            "friend": {"hp": int(), "attack": int(), "defense": int()},
        }
        self.percentage = {"hp": int(), "attack": int(), "defense": int()}
        self.units = [None] * 7
        self.unit = {"hp": None, "attack": None, "defense": None}
        self.links = [None] * 7
        self.calc_type = None
        self.font = ("Arial", 32)

        self.configure_window()

    def configure_window(self) -> None:
        self.title("Dokkan Calculator")
        self.resizable(False, False)
        self.geometry(f"{self.WIDTH}x{self.HEIGHT}")
        self.icons = [
            ImageTk.PhotoImage(Image.open("assets/heart.png").resize((100, 100))),
            ImageTk.PhotoImage(Image.open("assets/sword.png").resize((100, 100))),
            ImageTk.PhotoImage(Image.open("assets/shield.png").resize((100, 100))),
            ImageTk.PhotoImage(Image.open("assets/ball.png")),
        ]

        self.iconphoto(True, self.icons[-1])
        self.center_self()
        self.run()

    def center_self(self) -> None:
        self.update()
        window_width = self.winfo_width()
        window_height = self.winfo_height()
        screen_width = self.winfo_screenwidth()
        screen_height = self.winfo_screenheight()
        x = int((screen_width / 2) - (window_width / 2))
        y = int((screen_height / 2) - (window_height / 2))
        self.geometry(f"{window_width}x{window_height}+{x}+{y}")

    def run(self) -> None:
        """_summary_
        Creates Three buttons for user to choose which stat they want to calculate
        """
        frame1 = Frame(self)
        Label(frame1, text="Pick stat to calculate", font=self.font).pack(anchor=CENTER)
        frame1.pack()

        frame2 = Frame(self)

        hp = Entry(frame2, width=4, bg="#E5E5E5", bd=2, font=("Arial", 16, "bold"))
        hp.grid(row=2, column=0, pady=5)
        atk = Entry(frame2, width=4, bg="#E5E5E5", bd=2, font=("Arial", 16, "bold"))
        atk.grid(row=2, column=1, pady=5)
        df = Entry(frame2, width=4, bg="#E5E5E5", bd=2, font=("Arial", 16, "bold"))
        df.grid(row=2, column=2, pady=5)

        Button(
            frame2,
            image=self.icons[0],
            command=lambda event="hp": self.get_button(event, hp.get()),
        ).grid(row=1, column=0, padx=30)
        Button(
            frame2,
            image=self.icons[1],
            command=lambda event="attack": self.get_button(event, atk.get()),
        ).grid(row=1, column=1, padx=30)
        Button(
            frame2,
            image=self.icons[2],
            command=lambda event="defense": self.get_button(event, df.get()),
        ).grid(row=1, column=2, padx=30)
        frame2.pack(pady=20)

    def get_button(self, event: str, leader: int) -> None:
        """_summary_
            Based on what button the user clicks, will configure the calculator to calc the stat

        Args:
            event (_type_): _description_ Type of stat the user wants to calc (Hp/Attack/Defense)
            leader (_type_): _description_ Leaderskill integer
        """
        if leader:
            leader = int(leader)
            self.leaderskill["player"][event] = leader
            self.leaderskill["friend"][event] = leader
            self.calc_type = event
            response = messagebox.askyesno(
                parent=self,
                title="Friend Leaderskill",
                message="Is the friend leaderskill different?",
            )
            if response:
                self.leaderskill["friend"][event] = simpledialog.askinteger(
                    parent=self, title="Friend Leaderskill", prompt="Enter Leaderskill"
                )

            leader = (
                self.leaderskill["player"][event] + self.leaderskill["friend"][event]
            )

            self.percentage[event] = (leader / 100) + 1.0
            print(self.leaderskill, self.percentage)
            self.after(0, self.calc_window)
        else:
            messagebox.showwarning(
                parent=self,
                title="No data",
                message="Please provide a leaderskill to begin calculations",
            )

    def calc_window(self) -> None:
        """_summary_
        Creates a new window and based on the users previous selections decides whether to calc (Hp/Attack/Defense)
        """
        window = Toplevel()
        self.resizable(False, False)

        if self.calc_type == "hp":
            window.title("Hp")
            self.calc_hp(window)
        elif self.calc_type == "attack":
            window.title("Attack")
        elif self.calc_type == "defense":
            window.title("Defense")
        else:
            print("something went wrong")

    def calc_hp(self, parent) -> None:
        top_frame = Frame(parent)
        self.team_total = Entry(top_frame, font=self.font, fg="white", bg="#818181")
        self.team_total.insert(0, f"Team Hp: {self.total_hp}")
        self.team_total.pack(anchor=CENTER, padx=20, pady=20)
        top_frame.pack()

        mid_frame = Frame(parent)

        mid_left_frame = Frame(mid_frame)
        Label(mid_left_frame, text="Units").grid(row=0, column=0)
        listbox_font = list(self.font)
        listbox_font[1] = 24
        listbox_font.append("bold")
        self.lb = Listbox(
            mid_left_frame,
            height=7,
            width=30,
            font=listbox_font,
            selectmode=MULTIPLE,
            relief=SUNKEN,
            bd=5,
        )
        self.lb.grid(row=1, column=0, pady=20)

        mid_right_frame = Frame(mid_frame)
        Label(mid_right_frame, text="Unit Name").grid(row=0, column=1)
        unit_name = Entry(mid_right_frame, font=self.font)
        unit_name.grid(row=1, column=1)
        Label(mid_right_frame, text="Unit Hp").grid(row=2, column=1)
        unit_hp = Entry(mid_right_frame, font=self.font)
        unit_hp.grid(row=3, column=1)
        submit_btn = Button(
            mid_right_frame,
            text="Add",
            font=self.font,
            command=lambda: self.add_items(unit_name, unit_hp, mid_frame),
        )
        submit_btn.grid(row=4, column=1, pady=20)

        mid_left_frame.grid(row=0, column=0, padx=20)
        mid_right_frame.grid(row=0, column=1, padx=20)

        mid_frame.pack()

    def add_items(self, name, hp, parent):
        if hp.get().isnumeric():
            self.lb.insert(self.lb.size(), [name.get(), int(hp.get())])
            name.delete(0, END)
            name.focus()
            hp.delete(0, END)
            self.on_item_added()
        else:
            messagebox.showwarning(
                parent=parent,
                title="Invalid Input",
                message="Hp value must be a number",
            )

    def on_item_added(self):
        """_summary_
        listener for when listbox adds an item, will update the total hp of team every time a new unit is added or removed(future)
        """
        self.team_total.delete(0, END)
        total = 0

        for i in range(self.lb.size()):
            total += self.lb.get(i)[1]

        self.total_hp = total * self.percentage.get("hp")

        self.team_total.insert(0, f"Team Hp: {self.total_hp}")


if __name__ == "__main__":
    app = App()
    app.mainloop()
