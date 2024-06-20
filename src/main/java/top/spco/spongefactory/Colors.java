/*
 * Copyright 2024 SpCo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package top.spco.spongefactory;

public class Colors {
    public static final int POTASSIUM = 0xFFD396D3;
    public static final int SODIUM = 0xFFE5AFAF;
    public static final int CALCIUM = 0xFF85A6AF;
    public static final int TITANIUM = 0xFFFCCCEF;
    public static final int SODIUM_OXIDE = 0xFFFFF6DB;
    public static final int SODIUM_PEROXIDE = 0xFFFFEBAF;
    public static final int SODIUM_NITRATE = 0xFFFFF7DF;
    public static final int SODIUM_NITRITE = 0xFFFFEAAC;
    public static final int HYDROCHLORIDE = 0xFFBFD1E1;
    public static final int HYPOCHLORITE = 0xFFCDDBEC;
    public static final int SIGNALUM = 0xFFEC3606;
    public static final int LUMIUM = 0xFFf4dd71;
    public static final int CHORUS = 0xFF8D638D;
    public static final int DESH = 0xFFD68D4D;
    public static final int NETHERITE = 0xFF2B292A;
    public static final int BAUXITE = 0xFFAE744E;

    // gasColor
    public static final int CARBON_DIOXIDE = 0xD0D0D0;
    public static final int CARBON_MONOXIDE = 0xE2E2E2;
    public static final int NICKEL = 0xAE9E74;
    public static final int NICKEL_OXIDE = 0xDEDFBB;
    public static final int NICKEL_TETRACARBONYL = 0x978965;
    public static final int ALUMINUM = 0xBEC5C9;
    public static final int MATTER = 0xFFFFFF;
    public static final int OSMIUM_TETROXIDE = 0xACCCD5;
    public static final int OSMIUM = 0x84B5C3;
    public static final int AMMONIA = 0x6FB0F6;
    public static final int AMMONIA_WATER = 0x8989BD;
    public static final int URANIUM = 0xA2F2A0;
    public static final int URANIUM_DIOXIDE = 0xA7B558;
    public static final int URANYL_SULFATE = 0xBAAE4F;
    public static final int AMMONIUM_DIURANATE = 0x395A47;
    public static final int URANIUM_TETRAFLUORIDE = 0x7A915C;
    public static final int NITROGEN = 0xCCA3A7;
    public static final int ARGON = 0xF875DD;

    public static int convertToArgb(int rgbColor) {
        return convertToArgb(0xFF, rgbColor);
    }

    public static int convertToArgb(int alpha, int rgbColor) {
        return (alpha << 24) | rgbColor;
    }
}