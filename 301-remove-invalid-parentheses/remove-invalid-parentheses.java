class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.add(s);
        visited.add(s);

        boolean found = false;

        while (!q.isEmpty()) {

            String curr = q.poll();

            if (valid(curr)) {
                ans.add(curr);
                found = true;
            }

            // Once valid strings are found,
            // don't remove more characters.
            if (found)
                continue;

            for (int i = 0; i < curr.length(); i++) {

                // Remove only parentheses
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')')
                    continue;

                String next = curr.substring(0, i)
                        + curr.substring(i + 1);

                if (!visited.contains(next)) {
                    visited.add(next);
                    q.add(next);
                }
            }
        }

        return ans;
    }

    public boolean valid(String s) {

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') {
                st.push(c);
            }

            else if (c == ')') {

                if (st.isEmpty())
                    return false;

                st.pop();
            }
        }

        return st.isEmpty();
    }
}