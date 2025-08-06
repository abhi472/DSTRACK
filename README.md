Get started by customizing your environment (defined in the .idx/dev.nix file) with the tools and IDE extensions you'll need for your project!

Learn more at https://firebase.google.com/docs/studio/customize-workspace



graph TD
    subgraph User
        U["User"]
    end

    subgraph "Android Assistant App (Phone)"
        A_UI["App UI & Logic <br/>(e.g., Activities, Managers)"]
        A_SDK["Emdoor `aiglasses_sdk_lib`<br/>(Core SDK for Glasses Interaction)"]
        A_PMIC["Phone Microphone/<br/>Speaker"]
        A_FS["Phone Local Storage"]

        A_UI -- "Orchestrates" --> A_SDK
        A_SDK -- "Uses" --> A_PMIC
        A_SDK -- "Manages Access To" --> A_FS
    end

    subgraph "Emdoor Smart Glasses"
        G_HW["Glasses Hardware & Sensors"]
        G_MIC_SPK["Glasses Microphone/<br/>Speaker"]
        G_FS["Glasses Internal Storage"]

        G_HW -- "Contains" --> G_MIC_SPK
        G_HW -- "Contains" --> G_FS
    end

    subgraph "Emdoor Cloud Services"
        C_AI["AI Backend <br/>(ASR, NLP, TTS, Translate, Image Analysis)"]
        C_FW["Firmware Update Server"]
    end

    %% Phase 1: Initial Setup & Binding
    subgraph "1. First-Time Setup & Binding"
        U -- "1. Initiate Scan/Bind" --> A_UI
        A_UI -- "2. Scan for BLE Devices" --> A_SDK
        A_SDK -- "3. BLE Discovery & Pairing" --> G_HW
        G_HW -- "4. Provide Device Info" --> A_SDK
        A_SDK -- "5. Establish Bond & Connect (BLE)" --> G_HW
        A_SDK -- "6. Store Bound Device Info" --> A_FS
    end

    %% Phase 2: Remote Control & Monitoring
    subgraph "2. Remote Control & Status Monitoring"
        U -- "Command: Take Photo, Start/Stop Video/Audio Recording" --> A_UI
        A_UI -- "Control Command (via SDK)" --> A_SDK
        A_SDK -- "BLE Command Packet" --> G_HW
        G_HW -- "Action Performed / Status Updates (Battery, Wear, Recording Time) (BLE)" --> A_SDK
        A_SDK -- "Update UI / Notify User" --> A_UI
    end

    %% Phase 3: Data Sync & Configuration
    subgraph "3. Data Sync & Configuration"
        subgraph "3.1 Media Export"
            U -- "Request Media Files" --> A_UI
            A_UI -- "Request File List (BLE)" --> A_SDK
            A_SDK -- "Query Files" --> G_FS
            G_FS -- "File Metadata" --> A_SDK
            A_SDK -- "Initiate Wi-Fi Direct/AP Mode Connection" --> G_HW
            G_HW -- "Establish Wi-Fi Link (P2P/AP)" --> A_SDK
            A_SDK -- "Request File Transfer (TCP)" --> G_FS
            G_FS -- "Stream Media Data (TCP)" --> A_SDK
            A_SDK -- "Save to Storage" --> A_FS
        end
        subgraph "3.2 Glasses Settings"
            U -- "Adjust Settings (Gestures, Language, Wi-Fi Config)" --> A_UI
            A_UI -- "Setting Command (via SDK)" --> A_SDK
            A_SDK -- "BLE Command" --> G_HW
            G_HW -- "Apply & Confirm" --> A_SDK
        end
    end

    %% Phase 4: Advanced AI Features
    subgraph "4. AI Interaction"
        subgraph "4.1 Voice AI (Chat / Real-time Translation)"
            direction LR
            U -- "Speak Voice Command" --> G_MIC_SPK
            U -- "Speak Voice Command" --> A_PMIC

            G_MIC_SPK -- "Audio Stream (SPP/BLE)" --> A_SDK
            A_PMIC -- "Audio Stream (Local Record)" --> A_SDK

            A_SDK -- "Stream Audio (WebSocket)" --> C_AI
            C_AI -- "ASR, NLP (Commands), Translation, TTS Audio (WebSocket)" --> A_SDK

            A_SDK -- "Play TTS Audio (XTP/SPP)" --> G_MIC_SPK
            A_SDK -- "Play TTS Audio (Local AudioTrack)" --> A_PMIC
            A_SDK -- "Display AI Response" --> A_UI
        end
        subgraph "4.2 Image Understanding"
            U -- "Initiate Image Analysis" --> A_UI
            A_UI -- "Command: Take Photo (BLE)" --> A_SDK
            A_SDK -- "Take Photo" --> G_HW
            G_HW -- "Captured Image Data" --> A_SDK
            A_SDK -- "Upload Image + Query (HTTP/WebSocket)" --> C_AI
            C_AI -- "Analysis Result (Text/Audio)" --> A_SDK
            A_SDK -- "Display Result" --> A_UI
        end
    end

    %% Phase 5: Maintenance
    subgraph "5. Firmware Updates (OTA)"
        U -- "Check for Firmware Update" --> A_UI
        A_UI -- "Query Latest Version (HTTP)" --> C_FW
        C_FW -- "Firmware Metadata (URL, Version)" --> A_SDK
        A_SDK -- "Download Firmware Package (HTTP)" --> A_FS
        A_SDK -- "Notify Glasses: Ready for Update (BLE)" --> G_HW
        A_SDK -- "Initiate Wi-Fi Direct/AP Connection" --> G_HW
        G_HW -- "Establish Wi-Fi Link" --> A_SDK
        A_SDK -- "Upload Firmware (TCP)" --> G_HW
        G_HW -- "Internal Firmware Flashing" --> G_HW
        G_HW -- "Update Status (BLE)" --> A_SDK
        A_SDK -- "Update UI" --> A_UI
    end
