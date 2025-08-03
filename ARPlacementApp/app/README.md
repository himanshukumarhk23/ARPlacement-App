# 📱 ARPlacementApp – Augmented Reality Drill Marker App

ARPlacementApp is an Android application built using **Google ARCore** and **Sceneform**. It allows users to simulate safety drills by placing **virtual 3D markers** (like fire or earthquake drills) on real-world surfaces using **Augmented Reality (AR)**.

---

## ✨ Features

- ✅ Select a predefined drill (Fire, Earthquake, etc.)
- 📍 Tap on a surface to place a virtual 3D marker (cube)
- ❌ Prevents multiple object placements (only one marker allowed)
- 📋 Drill detail screen to show drill instructions or info

---

## 🧱 Tech Stack

- **Kotlin** – Modern Android programming language
- **ARCore** – Augmented Reality platform by Google
- **Sceneform** – High-level 3D rendering framework
- **Minimum SDK** – 24
- **Target SDK** – 34

---

## 🧾 Screenshots

![first.jpg](src%2Fmain%2Fres%2Fdrawable%2Ffirst.jpg)
![2nd.jpg](..%2F..%2F..%2FDesktop%2F2nd.jpg)
![3rd.jpg](..%2F..%2F..%2FDesktop%2F3rd.jpg)
![4th.jpg](..%2F..%2F..%2FDesktop%2F4th.jpg)

---

## 🔧 How to Build & Run

### Step 1: Clone the Repository
```bash
git clone https://github.com/your-username/ARPlacementApp.git
cd ARPlacementApp

Step 2: Open in Android Studio
Open the project folder

Let Gradle sync automatically

Step 3: Configure Dependencies
Ensure these are added in app/build.gradle.kts:

kotlin
Copy
Edit
implementation("com.google.ar:core:1.41.0")
implementation("com.google.ar.sceneform.ux:sceneform-ux:1.17.1")
Step 4: Test on Physical Device
❗ ARCore only works on supported devices. Emulator will not support AR functionality.

Check supported devices:
👉 https://developers.google.com/ar/devices

📁 Project Structure
pgsql
Copy
Edit
ARPlacementApp/
├── app/
│   ├── java/com/example/arplacementapp/
│   │   ├── MainActivity.kt
│   │   ├── ARActivity.kt
│   │   └── DrillDetailsActivity.kt
│   └── res/
│       ├── layout/
│       │   ├── activity_main.xml
│       │   ├── activity_aractivity.xml
│       │   └── activity_drill_details.xml
│       └── values/strings.xml
├── build.gradle.kts (app-level and project-level)
└── README.md

❗ Known Issues
Sceneform is no longer officially maintained. Still works for basic 3D use-cases.

ARCore will not work on all devices. Use a physical device with proper support.

📜 License
This project is licensed under the MIT License.
You’re free to use, modify, and distribute.

🙌 Author
Made with ❤️ by Himanshu Kumar
📧 [E-mail : himanshukumarhk6600@gmail.com  &&  Github : https://github.com/himanshukumarhk23]

💡 Suggestions for Improvement

Replace default cube with custom 3D models (GLB/GLTF)
Add audio instructions for drills