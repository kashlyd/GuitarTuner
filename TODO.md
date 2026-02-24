# TODO — Guitar Tuner App

## Setup
- [ ] Add `.gitignore` (Android Studio / IntelliJ)
- [ ] Add `README.md` (project overview + how to run)
- [ ] Add project structure notes (folders, modules)
- [ ] Confirm collaborator access (prof invited + accepted)

## Core Features (MVP)
- [ ] Microphone permission flow (Allow / Deny / Tone-mode fallback)
- [ ] Real-time pitch detection (mic input -> frequency)
- [ ] Note detection (frequency -> note name + octave)
- [ ] Cents calculation (difference from target note)
- [ ] Tuning UI (needle/gauge + in-tune zone)
- [ ] Auto-string detection (match closest target string)
- [ ] Manual string selection (tap string buttons)
- [ ] Hold last stable reading (freeze display)

## Tuning Standards
- [ ] Global A4 reference pitch setting (415–466 Hz, default 440)
- [ ] Preset chips for A4 (415 / 432 / 440 / 442 / 443)
- [ ] Apply reference pitch to frequency-to-note mapping
- [ ] Temperament system: Equal Temperament (default)
- [ ] (Optional) Experimental temperaments (Just / Pythagorean / Werckmeister / Meantone)
- [ ] Capo / transpose support (0–12)
- [ ] (Optional) Sweetened tuning offsets (per-string cents)

## Tuning Presets Library
- [ ] Default tuning presets (Standard, Drop D, Open G, DADGAD, Half-step down, etc.)
- [ ] Instrument filters (Guitar 6/7, Bass 4/5, Ukulele)
- [ ] Search tunings by name/tag
- [ ] Favorites + Recent tunings
- [ ] Select preset -> updates main tuner targets

## Custom Tuning Builder
- [ ] Create tuning (name + instrument type)
- [ ] Edit strings by note + octave
- [ ] Quick actions (Start from Standard, Down-tune all, Drop one string)
- [ ] Save custom tuning locally
- [ ] Duplicate / rename / delete custom tunings
- [ ] (Optional) Per-preset standards override (use global vs custom A4)

## Tools
- [ ] Tone generator (play target string / reference A / chord)
- [ ] Volume + loop controls
- [ ] (Optional) Tuning history (date + preset + avg cents per string)
- [ ] (Optional) Export history (CSV)

## Quality & Testing
- [ ] Smoothing / stability filter (reduce jitter)
- [ ] Noise handling (noise gate / confidence meter)
- [ ] Test on different guitars + environments
- [ ] Unit tests for note mapping + cents math
- [ ] UI tests for main flows (permission, preset selection, builder)

## Documentation
- [ ] Update `README.md` with:
  - [ ] App features
  - [ ] Screenshots (main tuner + standards + presets)
  - [ ] How to run/build
  - [ ] Any limitations / known issues
- [ ] Add brief design notes (why A4 matters, why equal temperament default)
- [ ] Add credits / libraries used

## Submission Checklist
- [ ] Repo is public/private as required
- [ ] Prof has collaborator access
- [ ] Clean commit history (meaningful messages)
- [ ] Tag release: `v1.0-mvp`
- [ ] Final demo video / screenshots uploaded (if needed)
