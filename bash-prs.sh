#!/bin/bash

# Hardened bash
export LC_ALL="C"
set -euo pipefail

# Constants: map letter to name
declare -rA name_map=(R rock P paper S scissors)

# Variables: keep score (points from their viewpoint)
declare -gi win=0 lose=0 draw=0

# Function echoes random pick from characters R, P, S
pick_move() {
    declare -ra options=(R P S)
    echo ${options[$((RANDOM % 3))]}
}

# Function determines outcome for $1 (theirs) vs $2 (mine)
# Updates global scores and echoes the round's outcome
eval_round() {
    case "$1$2" in
      RR|PP|SS) draw=$((++draw)); echo "It's a draw." ;;
      RS|SP|PR) win=$((++win));   echo "You win!"     ;;
      SR|PS|RP) lose=$((++lose)); echo "I win."       ;;
      *) echo " *** programmer error: $1$2 ***" >&2 && return 1
    esac && echo
}

# Main loop
declare -u theirs=''  # Note the -u makes 'theirs' autoconvert to uppercase
while [[ "$theirs" != 'Q' ]]; do

    # Read input and validate
    read -n 1 -p "Choose [r]ock, [p]aper, [s]cissors, or [q]uit: " theirs && echo
    [[ -n "${theirs}" && -z "${theirs//[RPS]}" ]] || continue

    mine=$(pick_move)

    printf '\nYou play %s, I play %s. ' ${name_map[$theirs]} ${name_map[$mine]}
    eval_round $theirs $mine

done

printf '\nFinal score: you won %d, I won %d, we drew %d.\n' $win $lose $draw

# vim: sts=4:sw=4:et:ai:si 
